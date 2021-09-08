package data.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import shoppingitem

class Shoppingrepository(
    private val db:shoppingDatabase
){
    fun upsert(item: shoppingitem)=db.getShoppingDAO().upsert(item)
    fun delete(item: shoppingitem)=db.getShoppingDAO().delete(item)
    fun getAllshoppingitems()=db.getShoppingDAO().getAllShoppingitems()

}

class shoppingDatabase {
    @Database(
        entities = [shoppingitem::class], version = 1
                abstract class shoppingDatabase : RoomDatabase {
            abstract fun getshoppingDao(): shoppingDAO

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
        class shoppingitem<> {

    }
}

}
class ShoppingRepository(instance: Any) {

}
