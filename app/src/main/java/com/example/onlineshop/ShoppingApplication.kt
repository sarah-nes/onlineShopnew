package com.example.onlineshop

import android.app.Application
import com.example.onlineshop.data.db.ShoppingDatabase
import com.example.onlineshop.data.repository.ShoppingRepository
import com.example.onlineshop.ui.shoppinglist.ShoppingViewModelFactory
import data.repository.ShoppingRepository
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import ui.shoppinglist.ShoppingViewModelFactory

class ShoppingApplication: Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@ShoppingApplication))
        bind() from this.singleton {ShoppingDatabase(instance())}
        bind() from this.singleton {
            ShoppingRepository(instance())
        }
        bind() from provider {
            ShoppingViewModelFactory(
                instance()
            )
        }
    }
}