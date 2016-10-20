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
        column("title", Entry::title).weigthedWidth(1.0)
        column("synopsis", Entry::synopsis).weigthedWidth(4.0)
        columnResizePolicy = SmartResize.POLICY
        controller.categoryModel.itemProperty.onChange {
            items.setAll(controller.entries[it!!.index])
        }
    }


}

class CategoryListView : View() {
    val controller: MainController by inject()
    override val root = listview<Category> {
        prefWidth= 100.0
        items = controller.categories.observable()

        cellFormat { text = it.title }
        bindSelected(controller.categoryModel)
    }

}
