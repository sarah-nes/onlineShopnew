package data.db

import ShoppingItem
import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room
import androidx.room.Context
import data.repository.shoppingDatabase
import shoppingDAO

@Database(
    entities = [ShoppingItem::class], version = 1
            abstract class shoppingDatabase : RoomDatabase {
        fun getshoppingDao(): shoppingDAO {}

        companion object {
            @Volatile
            private var instance: shoppingDatabase? = null
            private val LOCK = Any()
            instance?:createDatabase(context).also
            { instance = it }
        }

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK)
        private fun createDatabase(contect: Context) =
            Room.databasebuilder(
                context.applicationContext,
                shoppingDatabase::class.java, name:"shoppingDB.db").build()


    }

