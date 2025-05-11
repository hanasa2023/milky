package org.ntqqrev.saltify.milky.generator.markdown

import org.ntqqrev.saltify.composeidl.Category
import org.ntqqrev.saltify.composeidl.Struct
import java.nio.file.Path

class MarkdownGenerator(
    val documentedStructs: List<Struct>,
    val apiCategories: List<Category>
) {
    val categoryMarkdownGenerator = CategoryMarkdownGenerator(this)
    val apiMarkdownGenerator = ApiMarkdownGenerator(this)
    val typeMarkdownGenerator = TypeMarkdownGenerator(this)

    fun generate(basePath: Path) {
        val apiCategoryDir = basePath.resolve("api")
        val structDir = basePath.resolve("struct")

        apiCategoryDir.toFile().mkdirs()
        structDir.toFile().mkdirs()

        documentedStructs.forEach { struct ->
            val fileName = "${struct.name}.md"
            val filePath = structDir.resolve(fileName)
            filePath.toFile().writeText(typeMarkdownGenerator.generateTypeDocument(struct))
        }

        apiCategories.forEach { category ->
            val fileName = "${category.name}.md"
            val filePath = apiCategoryDir.resolve(fileName)
            filePath.toFile().writeText(categoryMarkdownGenerator.generate(category))
        }
    }
}