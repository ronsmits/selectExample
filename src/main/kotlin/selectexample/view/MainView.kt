package selectexample.view

import selectexample.controller.MainController
import selectexample.model.Category
import selectexample.model.Entry
import tornadofx.*

class MainView : View("Hello TornadoFX Application") {
    val categoryListView: CategoryListView by inject()
    val entryView : EntryView by inject()
    override val root = borderpane {
        left = categoryListView.root
        center = entryView.root

    }
}

class EntryView : View(){
    val controller : MainController by inject()
    override val root = tableview<Entry> {
        column("title", Entry::title)
        column("synopsis", Entry::synopsis)
    }
    init {
        controller.categoryModel.setOnRebind {
            root.items = controller.entries[controller.categoryModel.category.index].observable()
        }
    }
}

class CategoryListView : View() {
    val controller: MainController by inject()
    override val root = listview<Category> {
        items = controller.categories.observable()

        cellFormat { text = "${it.title}" }

        onUserSelect(clickCount = 1) {
            controller.categoryModel.rebind { category = it }
            //entryView.selectCategory(it)
        }
    }

}
