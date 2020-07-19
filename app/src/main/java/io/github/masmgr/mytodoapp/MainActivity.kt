package io.github.masmgr.mytodoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {
    private val mainViewModel = MainViewModel()
    private lateinit var adapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = TodoAdapter(
            MutableList(50) { i ->
                TodoItem("List ${i + 1}", "This is ${i + 1} item.", Date())
            },
            TodoListListener(applicationContext)
        )

        main_recycler_view.layoutManager = LinearLayoutManager(this)
        main_recycler_view.adapter = adapter
        main_recycler_view.setHasFixedSize(true)

        add_item_button.setOnClickListener {
            mainViewModel.addItem(
                text_title.text.toString(),
                text_detail.text.toString()
            )
        }

        ItemTouchHelper(TodoItemTouchHelperCallback(adapter)).attachToRecyclerView(
            main_recycler_view
        )

        mainViewModel.todo.observe(this, Observer {
            adapter.setItem(it)
        })
    }
}