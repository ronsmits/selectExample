package selectexample.controller

import selectexample.model.Category
import selectexample.model.CategoryModel
import selectexample.model.Entry
import tornadofx.Controller

class MainController : Controller() {

    val categoryModel = CategoryModel()

    val categories = listOf(
            Category("a", 0),
            Category("b", 1),
            Category("c", 2),
            Category("d", 3)
    )

    val entries = listOf(
            listOf(
                    Entry("a", "aaa")),
            listOf(
                    Entry("b", "bbb")),
            listOf(
                    Entry("c", "ccc")),
            listOf(
                    Entry("d", "ddd"))
    )

}