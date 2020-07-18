package io.github.masmgr.mytodoapp

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
                 TodoItem("List ${i+1}", "This is ${i+1} item.", Date())
            },
            object : TodoAdapter.ListListener {
                override fun onClickRow(view: View, rowModel: TodoItem) {
                    val toast =
                        Toast.makeText(applicationContext, rowModel.Title, Toast.LENGTH_LONG)
                    // toast.setGravity(Gravity.TOP, 0, 0)
                    toast.show()
                }
            }
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

        getSwipeToDismissTouchHelper(adapter).attachToRecyclerView(main_recycler_view)

        mainViewModel.todo.observe(this, Observer {
            adapter.setItem(it)
        })
    }

    private fun getSwipeToDismissTouchHelper(adapter: TodoAdapter) =
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN or ItemTouchHelper.RIGHT,
            ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                val fromPosition = viewHolder.adapterPosition
                val toPosition = target.adapterPosition
                adapter.move(fromPosition, toPosition)
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                adapter.remove(viewHolder.adapterPosition)
            }

            override fun onChildDraw(
                c: Canvas,
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                dX: Float,
                dY: Float,
                actionState: Int,
                isCurrentlyActive: Boolean
            ) {
                super.onChildDraw(
                    c,
                    recyclerView,
                    viewHolder,
                    dX,
                    dY,
                    actionState,
                    isCurrentlyActive
                )
                val itemView = viewHolder.itemView
                val background = ColorDrawable()
                background.color = Color.YELLOW
                if (dX > 0) {
                    background.setBounds(
                        itemView.left,
                        itemView.top,
                        itemView.left + dX.toInt(),
                        itemView.bottom
                    )
                }
                background.draw(c)
            }
        })
}