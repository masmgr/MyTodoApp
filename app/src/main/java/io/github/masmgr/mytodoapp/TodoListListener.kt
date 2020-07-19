package io.github.masmgr.mytodoapp

import android.content.Context
import android.view.View
import android.widget.Toast

class TodoListListener(private val applicationContext: Context): TodoAdapter.ListListener {
    override fun onClickRow(view: View, rowModel: TodoItem) {
        val toast =
            Toast.makeText(applicationContext, rowModel.Title, Toast.LENGTH_LONG)
        toast.show()
    }
}