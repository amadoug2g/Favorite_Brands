package com.playgroundagc.favoritebrands.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.playgroundagc.core.domain.model.Make

/**
 * Created by Amadou on 11/08/2022
 *
 */

class FragmentViewModel(application: Application) : AndroidViewModel(application) {
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

    fun toggleFavorite() {

    }
    //endregion
}