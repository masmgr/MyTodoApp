package io.github.masmgr.mytodoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.todo_item.view.*
import java.text.SimpleDateFormat
import java.util.*

class TodoAdapter() : RecyclerView.Adapter<TodoHolder>() {
    private val todoList = mutableListOf<TodoItem>();

    fun setItem(item: TodoItem) {
        todoList.add(item)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val item = layoutInflater.inflate(R.layout.todo_item, parent, false)
        return TodoHolder(item)
    }

    override fun getItemCount(): Int = todoList.size

    override fun onBindViewHolder(holder: TodoHolder, position: Int) {
        holder.view.let {
            val item = todoList[position]
            it.title.text = item.Title
            it.detail.text = item.Detail
            it.register_date.text = SimpleDateFormat(
                "yyyy/MM/dd hh:mm:ss"
            ).format(item.RegisterDate)
        }
    }
}