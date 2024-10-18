package com.example.mycityapp.data

import com.example.mycityapp.R

enum class CategoryType (val displayName:Int,val image:Int) {
    PARKS(R.string.park, R.drawable.park),
    RESTAURANTS(R.string.restaurants, R.drawable.restaurant),
    TOURISM(R.string.tourism, R.drawable.tourism),
    SHOPPING(R.string.shopping,R.drawable.shopping)
}