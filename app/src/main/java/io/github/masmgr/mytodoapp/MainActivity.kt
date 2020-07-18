package io.github.masmgr.mytodoapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rv =
            findViewById<View>(R.id.recyclerView) as RecyclerView
        val adapter = RecyclerViewAdapter(createDataset())
        val llm = LinearLayoutManager(this)
        rv.setHasFixedSize(true)
        rv.layoutManager = llm
        rv.adapter = adapter
    }

    private fun createDataset(): List<RowData> {
        val dataset = mutableListOf<RowData>()
        (0..49).forEach { i ->
            dataset += RowData(
                "タイトル${i}",
                "詳細${i}"
            )
        }
        return dataset
    }
}