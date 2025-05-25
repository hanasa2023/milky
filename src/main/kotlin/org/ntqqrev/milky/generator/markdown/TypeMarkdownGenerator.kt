package org.ntqqrev.milky.generator.markdown

import org.ntqqrev.saltify.composeidl.*
import org.ntqqrev.saltify.composeidl.Array

class TypeMarkdownGenerator(val ctx: MarkdownGenerator) {
    fun namedType(name: String): Type {
        return object : Type {
            override fun toString() = name
        }
    }

    fun generateTypeDocument(data: Type): String {
        return when (data) {
            is DiscriminatedUnion -> {
                val result = StringBuilder("# ${data.description}")
                result.appendLine()
                result.appendLine(generateDiscriminatedUnion(data))
                result.toString()
            }

            is Struct -> {
                val result = StringBuilder("# ${data.description}")
                result.appendLine()
                result.appendLine(generateStruct(data))
                result.toString()
            }

            else -> throw IllegalArgumentException("Unsupported type: ${data::class.simpleName}")
        }
    }

    fun generateStruct(data: Struct): String {
        val unresolvedStructs = mutableListOf<Pair<String, Struct>>()

        fun Type.toBriefString(key: String, isEnum: Boolean): String = when (this) {
            is Struct -> {
                if (this in ctx.documentedStructs)
                    "[${this.name}](../struct/${this.name}.md)"
                else {
                    unresolvedStructs.add(key to this)
                    this.name
                }
            }

            is TypeReference -> "[${this.reference}](../struct/${this.reference}.md)"
            is Array -> "Array<${this.elementType.toBriefString(key, isEnum)}>"
            else -> if (isEnum) {
                "enum (${this})"
            } else {
                this.toString()
            }
        }

        val result = StringBuilder()
            .appendLine("| 字段名 | 类型 | 描述 |")
            .appendLine("| --- | --- | --- |")
            .apply {
                data.fields.forEach { field ->
                    appendLine(
                        "| ${field.name} | ${field.type.toBriefString(field.name, field.enum != null)} | ${generateFieldDescription(field)} |"
                    )
                }
            }

        while (unresolvedStructs.isNotEmpty()) {
            val (key, struct) = unresolvedStructs.removeAt(0)
            result.appendLine()
            result.appendLine("$key 的具体定义如下：")
            result.appendLine()
            result.appendLine(generateStruct(struct))
        }

        return result.toString()
    }

    fun generateDiscriminatedUnion(data: DiscriminatedUnion): String {
        val result = StringBuilder("共有字段如下：")
        result.appendLine()
        result.appendLine()
        result.append(generateStruct(Struct {
            use(data)
            field(data.discriminator, StringType, "类型标识符")
            if (data.structInnerKey != null) {
                field(data.structInnerKey!!, namedType("struct"), "结构体")
            }
        }))
        if (data.structInnerKey != null) {
            result.appendLine()
            result.appendLine("不同的 ${data.discriminator} 值对应不同的 ${data.structInnerKey}，具体如下：")
            result.appendLine()
        } else {
            result.appendLine()
            result.appendLine("不同的 ${data.discriminator} 值对应不同的附加字段，具体如下：")
            result.appendLine()
        }
        data.structList.forEach { (key, struct) ->
            result.appendLine("## `${key}` ${struct.description}")
            result.appendLine()
            result.append(
                if (struct in ctx.documentedStructs)
                    "见 [${struct.name}](../struct/${struct.name}.md)\n\n"
                else generateStruct(struct)
            )
        }
        return result.toString()
    }

    fun generateFieldDescription(field: Field): String {
        val result = StringBuilder(field.description)

        if (field.isOptional)
            result.append("（**可选**）")

        if (field.deprecated)
            result.append("（**已弃用**：${field.deprecationMessage}）")

        if (field.enum != null)
            result.append("，可能值：${field.enum!!.joinToString(", ") { "`${it}`" }}")

        if (field.defaultValue != null)
            result.append("（默认值：`${field.defaultValue}`）")

        if (field.sample != null)
            result.append("（示例：`${field.sample}`）")

        return result.toString()
    }
}