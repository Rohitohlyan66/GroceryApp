package com.example.groceryapp.data.repository

import com.example.groceryapp.data.db.GroceryDatabase
import com.example.groceryapp.data.db.entities.GroceryEntity

class GroceryRepository(private var database: GroceryDatabase) {

    suspend fun insertItem(item: GroceryEntity) = database.getGroceryDAO().insertItem(item)

    suspend fun deleteItem(item: GroceryEntity) = database.getGroceryDAO().deleteItem(item)

     fun getAllItems() = database.getGroceryDAO().getAllItems()
}