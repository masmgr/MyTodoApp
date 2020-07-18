package io.github.masmgr.mytodoapp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ViewHolder(itemView: View) : ViewHolder(itemView) {
    var titleView = itemView.findViewById<View>(R.id.title) as TextView
    var detailView = itemView.findViewById<View>(R.id.detail) as TextView
}