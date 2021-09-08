package com.example.onlineshop

import AddShoppingItemDialog
import ShoppingItem
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onlineshop.other.ShoppingItemAdapter
import kotlinx.android.synthetic.main.activity_shopping.*
import ui.ShoppingViewModel
import ui.shoppinglist.AddDialogListener

abstract class ShoppingActivity : AppCompatActivity() {


    abstract val item: ShoppingViewModel
    lateinit var viewModel: ShoppingViewModel

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        viewmodelprovider().get(java = ShoppingViewModel::class.java).also { viewModel = item }

        val adapter = ShoppingItemAdapter(listOf(), viewModel)

        rvShoppingItems.layoutManager = LinearLayoutManager(this)
        rvShoppingItems.adapter = adapter

        observe(Observer1 {
            val it = null
            adapter.items = listOf(it)
            adapter.notifyDataSetChanged()
        })

        fab.setOnClickListener {
            AddShoppingItemDialog(
                this,
                object : AddDialogListener {
                    override fun onAddButtonClicked(item: ShoppingItem) {
                        viewModel.upsert(item)
                    }
                }).show()
        }
    }

    abstract fun viewmodelprovider(): Any

}

private fun Any.get(java: Class<ShoppingViewModel>): Nothing? {
    val item = null
    return item
}

fun observe(observer1: Observer1) {

}
