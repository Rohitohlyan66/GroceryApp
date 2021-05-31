package com.example.groceryapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.groceryapp.data.db.entities.GroceryEntity

@Database(entities = [GroceryEntity::class], version = 1)
abstract class GroceryDatabase : RoomDatabase() {

    abstract fun getGroceryDAO(): GroceryDAO

    companion object {
        @Volatile
        private var instance: GroceryDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }


        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                GroceryDatabase::class.java,
                "GroceryDB.db"
            ).build()
    }


}