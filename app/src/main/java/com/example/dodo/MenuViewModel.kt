package com.example.dodo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dodo.model.Meal
import com.example.dodo.network.RetrofitDataProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MenuViewModel : ViewModel() {

    private val _meals = MutableLiveData<MealsWithIngredient>()
    val meals: LiveData<MealsWithIngredient>
        get() = _meals

    fun askForMealBy(ingredient: String) {

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = RetrofitDataProvider()
                    .getServices()
                    .getMealByIngredient(ingredient)

                if (response.isSuccessful)
                    _meals.postValue(MealsWithIngredient(response.body()!!.meals, ingredient))
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

data class MealsWithIngredient(val meals: List<Meal>, val ingredient: String)
