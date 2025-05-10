package org.ntqqrev.saltify.milky.generator.markdown

import org.ntqqrev.saltify.composeidl.Category

class CategoryMarkdownGenerator(val ctx: MarkdownGenerator) {
    fun generate(data: Category): String = StringBuilder()
        .appendLine("# ${data.description}")
        .appendLine()
        .apply {
            data.apiList.forEach { api ->
                appendLine(ctx.apiMarkdownGenerator.generate(api))
            }
        }
        .toString()
}