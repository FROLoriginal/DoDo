package com.example.dodo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dodo.model.Meal
import com.example.dodo.network.RetrofitDataProvider
import com.example.dodo.network.RetrofitServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.Exception

class MenuViewModel : ViewModel() {

    private val _data = MutableLiveData<List<Meal>>()
    val data: LiveData<List<Meal>>
        get() = _data

    init {
        fetchData()
    }

    private fun fetchData() {

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = RetrofitDataProvider()
                    .getServices()
                    .getMealByIngredient("chicken_breast")

                if (response.isSuccessful) {
                    _data.postValue(response.body()!!.meals)
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
