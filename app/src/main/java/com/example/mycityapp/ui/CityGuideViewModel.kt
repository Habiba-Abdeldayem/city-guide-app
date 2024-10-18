package com.example.mycityapp.ui

import androidx.lifecycle.ViewModel
import com.example.mycityapp.data.CategoryType
import com.example.mycityapp.data.LocalDataProvider
import com.example.mycityapp.model.RecommendedPlace
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CityGuideViewModel:ViewModel() {
    private val _uiState = MutableStateFlow(CityGuideState())
    val uiState: StateFlow<CityGuideState> = _uiState

    init {
        initializeUiState()
    }

    private fun initializeUiState(){
        val categoryPlaces = LocalDataProvider.getPlaceData().groupBy { it.categoryType }
        _uiState.value = CityGuideState(
            allCategoryPlaces = categoryPlaces
        )
    }

    fun updateCurrentCategory(categoryType: CategoryType) {
        _uiState.update { it.copy(
            currentCategoryType = categoryType,
        ) }
        _uiState.update { it.copy(
            currentSelectedPlace = _uiState.value.currentCategoryPlaces[0]
        ) }
    }
    fun updateCurrentPlace(currentPlace: RecommendedPlace) {
        _uiState.update { it.copy(
            currentSelectedPlace = currentPlace,
        ) }
    }
}