package ui.shoppinglist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import data.repository.Shoppingrepository
import ui.ShoppingViewModel

class ShoppingViewModelFactory(
    private val repository: Shoppingrepository
): ViewModelProvider.NewInstanceFactory(){
    override fun <T: ViewModel?> create(modelClass:class: T<T> {}):T{
        return ShoppingViewModel() as T
    }
}