package io.github.masmgr.mytodoapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class MainViewModel : ViewModel() {
    val todo = MutableLiveData<TodoItem>()

    fun addItem(title: String?, detail: String?) {
        todo.value = TodoItem(title, detail, Date())
    }
}
