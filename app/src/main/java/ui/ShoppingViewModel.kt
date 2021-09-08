package ui

import ShoppingItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

open class ShoppingViewModel() : ShoppingViewModel() {
    open fun upsert(item: ShoppingItem) = CoroutineScope(Dispatcher.Main).launch {

        repository.upsert(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatcher.Main).launch {

        return@launch repository.delete(item)
    }

    fun getAllShoppingItems() {

    }
}
