package com.playgroundagc.favoritebrands.framework

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.playgroundagc.core.domain.model.Make
import com.playgroundagc.core.domain.usecases.ToggleFavoriteUC

/**
 * Created by Amadou on 11/08/2022
 *
 */

class FragmentViewModel(private val toggleFavoriteUC: ToggleFavoriteUC) :
    ViewModel() {

    //region Variables
    private var _makeList = MutableLiveData<MutableList<Make>>()
    val makeList: LiveData<MutableList<Make>> = _makeList

    init {
        initializeList()
    }
    //endregion

    //region Functions
    private fun initializeList() {
        val brandList = mutableListOf(
            Make("Alfa Romeo"),
            Make("Cadillac"),
            Make("BMW"),
            Make("Ford"),
            Make("Jeep"),
            Make("Fiat"),
            Make("Mazda"),
            Make("Tesla"),
            Make("Audi"),
            Make("Maserati"),
            Make("Mercedes"),
            Make("Citroen"),
            Make("Suzuki"),
            Make("Ram"),
            Make("Volkswagen"),
            Make("Toyota"),
            Make("Alpine"),
            Make("Mini"),
            Make("Ferrari"),
            Make("Saab"),
            Make("Bentley"),
            Make("Chevrolet"),
        )
        _makeList.value = brandList
    }

    fun getFavoriteCount(): String {
        val result = _makeList.value?.let { list ->
            list.filter { make ->
                make.isFavorite
            }
        }?.count() ?: 0

        return result.toString()
    }

    fun toggleFavorite(make: Make) {
        toggleFavoriteUC.invoke(make)
    }
    //endregion
}

class FragmentViewModelFactory(private val toggleFavoriteUC: ToggleFavoriteUC) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(
            ToggleFavoriteUC::class.java
        ).newInstance(toggleFavoriteUC)
    }
}