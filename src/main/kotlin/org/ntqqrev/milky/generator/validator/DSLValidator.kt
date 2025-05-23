package org.ntqqrev.milky.generator.validator

import org.ntqqrev.saltify.composeidl.*

class DSLValidator (
    val apiCategories : List<Category>,
    val documentedStructs: List<Struct>
) {
    fun validate() {
        checkDuplicateApiNames()
        checkDuplicateStructNames()
        checkFieldDescriptions()
        checkEnumValues()
        // checkFieldDefaults()
    }

    private fun checkDuplicateApiNames() {
        val seen = mutableMapOf<String, String>()

        apiCategories.forEach { category ->
            category.apiList.forEach { api ->
                val existing = seen.putIfAbsent(api.name, category.name)
                if (existing != null) {
                    throw IllegalArgumentException(
                        "Duplicate API name: '${api.name}' found in both '${existing}' and '${category.name}'"
                    )
                }
            }
        }
    }

    private fun checkDuplicateStructNames() {
        val structNames = mutableMapOf<String, String>()

        documentedStructs.forEach { struct ->
            val name = struct.name
            val existing = structNames.putIfAbsent(name, "documentedStructs")
            if (existing != null) {
                throw IllegalArgumentException("Duplicate Struct name: '$name' found multiple times")
            }
        }
    }

    private fun checkFieldDescriptions() {
        documentedStructs.forEach { struct ->
            struct.fields.forEach { field ->
                val desc = field.description
                if (desc.isNullOrBlank()) {
                    throw IllegalArgumentException("Field '${field.name}' in struct '${struct.name}' must have a non-empty description")
                }
            }
        }
    }

    private fun checkEnumValues() {
        documentedStructs.forEach { struct ->
            struct.fields.forEach { field ->
                val enumValues = field.enum
                if (enumValues != null && enumValues.size < 2) {
                    throw IllegalArgumentException(
                        "Field '${field.name}' in struct '${struct.name}' has an enum with fewer than 2 values"
                    )
                }
            }
        }
    }

    private fun checkFieldDefaults() {
        documentedStructs.forEach { struct ->
            struct.fields.forEach { field ->
                val hasDefault = field.defaultValue != null
                val isOptional = field.isOptional

                if (!isOptional && hasDefault) {
                    throw IllegalArgumentException(
                        "Field '${field.name}' in struct '${struct.name}' is required but has a default value"
                    )
                }
                if (isOptional && !hasDefault) {
                    throw IllegalArgumentException(
                        "Field '${field.name}' in struct '${struct.name}' is optional but does not have a default value"
                    )
                }
            }
        }
    }
}