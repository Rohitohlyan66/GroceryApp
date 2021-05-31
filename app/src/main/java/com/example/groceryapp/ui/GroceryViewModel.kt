package com.example.groceryapp.ui

import androidx.lifecycle.ViewModel
import com.example.groceryapp.data.db.entities.GroceryEntity
import com.example.groceryapp.data.repository.GroceryRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GroceryViewModel(private var repository: GroceryRepository) : ViewModel() {

    fun insertItem(item: GroceryEntity) = CoroutineScope(Dispatchers.Main).launch {
        repository.insertItem(item)
    }

    fun deleteItem(item: GroceryEntity) = CoroutineScope(Dispatchers.Main).launch {
        repository.deleteItem(item)
    }

    fun getAllItems() = repository.getAllItems()

}