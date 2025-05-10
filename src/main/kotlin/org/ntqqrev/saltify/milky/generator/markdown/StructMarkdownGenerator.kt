package org.ntqqrev.saltify.milky.generator.markdown

import org.ntqqrev.saltify.composeidl.Array
import org.ntqqrev.saltify.composeidl.Struct

class StructMarkdownGenerator(val ctx: MarkdownGenerator) {
    fun generate(struct: Struct): String {
        val unresolvedStructList: MutableList<Pair<String, Struct>> = mutableListOf()

        val root = StringBuilder()
            .appendLine("| 字段名 | 类型 | 描述 |")
            .appendLine("| --- | --- | --- |")
            .apply {
                struct.fields.forEach { field ->
                    appendLine(
                        "| ${field.name} | ${
                            when (field.type) {
                                is Struct -> {
                                    val struct = field.type as Struct
                                    if (ctx.documentedStructs.contains(struct))
                                        "../struct/${struct.name}"
                                    unresolvedStructList.add(Pair(field.name, struct))
                                    struct.name
                                }
                                is Array -> "Array<${field.type}>"
                                else -> field.type.toString()
                            }
                        } | ${field.description} |"
                    )
                }
            }

        while (unresolvedStructList.isNotEmpty()) {
            val (fieldName, struct) = unresolvedStructList.removeAt(0)
            root.appendLine()
            root.appendLine("$fieldName 的具体定义如下：")
            root.appendLine()
            root.appendLine("| 字段名 | 类型 | 描述 |")
            root.appendLine("| --- | --- | --- |")
            struct.fields.forEach { field ->
                root.appendLine(
                    "| ${field.name} | ${
                        when (field.type) {
                            is Struct -> {
                                val struct = field.type as Struct
                                unresolvedStructList.add(Pair(field.name, struct))
                                struct.name
                            }
                            is Array -> "Array<${field.type}>"
                            else -> field.type.toString()
                        }
                    } | ${field.description} |"
                )
            }
        }

        return root.toString()
    }
}