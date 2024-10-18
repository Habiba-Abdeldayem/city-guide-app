package com.example.mycityapp.ui

import com.example.mycityapp.data.CategoryType
import com.example.mycityapp.data.LocalDataProvider
import com.example.mycityapp.model.RecommendedPlace

data class CityGuideState(
    val allCategoryPlaces: Map<CategoryType,List<RecommendedPlace>> = emptyMap(),

    val currentCategoryType: CategoryType = CategoryType.PARKS,
    val currentSelectedPlace: RecommendedPlace = LocalDataProvider.defaultPlace,
    val currentTitleBarName: String = "",
) {
    val currentCategoryPlaces: List<RecommendedPlace>
        get() = allCategoryPlaces[currentCategoryType] ?: emptyList()
}