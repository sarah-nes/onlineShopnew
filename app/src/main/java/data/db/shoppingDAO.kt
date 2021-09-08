import data.db.entities.shoppingitem
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Delete

@Dao
interface shoppingDAO {
 @Insert(onConflict=OnConflictStrategy.REPLACE)
  suspend  fun upsert(item: shoppingitem)
    @Delete
    suspend fun delete(item: shoppingitem)
    @Query(value: "SELECT * FROM shopping_items")
    fun getAllShoppingItems():LiveData<List<shoppingitem>>
}