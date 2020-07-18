package io.github.masmgr.mytodoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(list: List<RowData>) :
    RecyclerView.Adapter<ViewHolder>() {
    private val list: List<RowData> = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate: View =
            LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return ViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleView.text = list[position].Title
        holder.detailView.text = list[position].Detail
    }

    override fun getItemCount(): Int = list.size
}