package com.example.mycityapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.mycityapp.data.CategoryType

data class RecommendedPlace (
    @StringRes val nameId:Int,
    @StringRes val descriptionId:Int,
    @StringRes val locationId:Int,
    @DrawableRes val imageId:Int,
    val categoryType: CategoryType
)