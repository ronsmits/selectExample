package selectexample.model

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.ViewModel

data class Category(val title: String, val index: Int)

class CategoryModel(var category: Category) : ViewModel() {
    val title = bind { SimpleStringProperty(category.title) }
    val index = bind { SimpleIntegerProperty(category.index) }
}


data class Entry(val title:String, val synopsis : String)