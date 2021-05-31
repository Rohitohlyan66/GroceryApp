package com.example.groceryapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.groceryapp.data.db.entities.GroceryEntity

@Dao
interface GroceryDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: GroceryEntity)

    @Delete
    suspend fun deleteItem(item: GroceryEntity)

    @Query("SELECT * FROM grocery")
    fun getAllItems(): LiveData<List<GroceryEntity>>


}