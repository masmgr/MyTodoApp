package io.github.masmgr.mytodoapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val todo = MutableLiveData<TodoItem>()

    fun addItem(title: String?, detail: String?) {
        todo.value = TodoItem(title, detail)
    }
}
