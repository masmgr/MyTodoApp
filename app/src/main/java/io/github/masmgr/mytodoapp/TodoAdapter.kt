package io.github.masmgr.mytodoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*

class TodoAdapter(
    private val todoList: MutableList<TodoItem>,
    private val listener: ListListener
) : RecyclerView.Adapter<TodoHolder>() {
    fun setItem(item: TodoItem) {
        todoList.add(item)
        notifyDataSetChanged()
    }

    fun remove(position: Int) {
        todoList.removeAt(position)
        notifyItemRemoved(position)
    }

    fun move(fromPosition: Int, toPosition: Int) {
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val item = layoutInflater.inflate(R.layout.todo_item, parent, false)
        return TodoHolder(item)
    }

    override fun getItemCount(): Int = todoList.size

    override fun onBindViewHolder(holder: TodoHolder, position: Int) {
        val item = todoList[position]
        holder.titleView.text = item.Title
        holder.detailView.text = item.Detail
        holder.registerDateView.text = SimpleDateFormat(
            "yyyy/MM/dd hh:mm:ss", Locale.JAPAN
        ).format(item.RegisterDate)
        holder.view.setOnClickListener {
            listener.onClickRow(it, item)
        }
    }

    interface ListListener {
        fun onClickRow(view: View, rowModel: TodoItem)
    }
}