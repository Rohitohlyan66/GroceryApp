package com.example.groceryapp

import android.app.Application
import com.example.groceryapp.data.db.GroceryDatabase
import com.example.groceryapp.data.repository.GroceryRepository
import com.example.groceryapp.ui.GroceryViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class GroceryApplication : Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@GroceryApplication))
        bind() from singleton { GroceryDatabase(instance()) }
        bind() from singleton { GroceryRepository(instance()) }
        bind() from provider { GroceryViewModelFactory(instance()) }
    }
}