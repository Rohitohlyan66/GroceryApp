package com.example.groceryapp.ui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.groceryapp.R
import com.example.groceryapp.data.db.entities.GroceryEntity
import kotlinx.android.synthetic.main.add_grocery_dialog.*

class AddGroceryItemDialog(context: Context, var addButtonListener: AddDialogListenerInterface) :
    AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_grocery_dialog)

        add_item.setOnClickListener {
            val name = item_name.text.toString()
            val quantity = item_quantity.text.toString().toInt()

            if (name.isEmpty() || quantity == 0) {
                Toast.makeText(context, "Both Fields Required", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val item = GroceryEntity(name, quantity)
            addButtonListener.onAddButtonClick(item)
            dismiss()
        }

        cancel_item.setOnClickListener {
            cancel()
        }

    }
}