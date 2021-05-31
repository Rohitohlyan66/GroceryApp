package com.example.groceryapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.groceryapp.R
import com.example.groceryapp.data.db.entities.GroceryEntity
import com.example.groceryapp.ui.GroceryViewModel
import kotlinx.android.synthetic.main.recycler_view_item.view.*

class RecyclerAdapter(var list: List<GroceryEntity>, private var viewModel: GroceryViewModel) :
    RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.itemView.item.text = list[position].name
        holder.itemView.quantity.text = "${list[position].quantity}"

        holder.itemView.delete.setOnClickListener {
            viewModel.deleteItem(list[position])
        }

        holder.itemView.decrease.setOnClickListener {
            if (list[position].quantity > 0) {
                list[position].quantity--
                viewModel.insertItem(list[position])
            }
        }

        holder.itemView.increase.setOnClickListener {
            list[position].quantity++
            viewModel.insertItem(list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}