package io.github.masmgr.mytodoapp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.todo_item.view.*

class TodoHolder(val view: View): RecyclerView.ViewHolder(view) {
    val titleView: TextView = view.title
    val detailView: TextView = view.detail
    val registerDateView: TextView = view.register_date
}