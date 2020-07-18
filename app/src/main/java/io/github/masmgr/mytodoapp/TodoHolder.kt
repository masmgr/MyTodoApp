package io.github.masmgr.mytodoapp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kotlinx.android.synthetic.main.todo_item.view.*

class TodoHolder(val view: View): RecyclerView.ViewHolder(view) {
    val title = view.title
    val detail = view.detail
}