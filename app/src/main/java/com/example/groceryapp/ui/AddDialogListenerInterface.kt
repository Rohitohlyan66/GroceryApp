package com.example.groceryapp.ui

import com.example.groceryapp.data.db.entities.GroceryEntity

interface AddDialogListenerInterface {

    fun onAddButtonClick(item: GroceryEntity)
}