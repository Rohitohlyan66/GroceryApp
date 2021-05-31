package com.example.groceryapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.groceryapp.adapters.RecyclerAdapter
import com.example.groceryapp.data.db.GroceryDatabase
import com.example.groceryapp.data.db.entities.GroceryEntity
import com.example.groceryapp.data.repository.GroceryRepository
import com.example.groceryapp.ui.AddDialogListenerInterface
import com.example.groceryapp.ui.AddGroceryItemDialog
import com.example.groceryapp.ui.GroceryViewModel
import com.example.groceryapp.ui.GroceryViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()
    private val factory: GroceryViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val viewModel = ViewModelProvider(this, factory).get(GroceryViewModel::class.java)
        val adapter = RecyclerAdapter(listOf(), viewModel)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapter


        viewModel.getAllItems().observe(this, Observer {
            adapter.list = it
            adapter.notifyDataSetChanged()
        })

        fab.setOnClickListener {
            AddGroceryItemDialog(this,
                object : AddDialogListenerInterface {
                    override fun onAddButtonClick(item: GroceryEntity) {
                        viewModel.insertItem(item)
                    }
                }).show()
        }
    }
}