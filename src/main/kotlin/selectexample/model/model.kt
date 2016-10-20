package selectexample.model

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.ItemViewModel
import tornadofx.ViewModel

data class Category(val title: String, val index: Int)

class CategoryModel() : ItemViewModel<Category>() {
    val title = bind { SimpleStringProperty(item?.title ?: "") }
    val index = bind { SimpleIntegerProperty(item?.index ?: 0) }
}

data class Entry(val title:String, val synopsis : String)