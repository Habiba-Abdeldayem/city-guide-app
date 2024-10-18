package com.example.mycityapp.data

import com.example.mycityapp.R
import com.example.mycityapp.model.RecommendedPlace

object LocalDataProvider {

    val defaultPlace =  RecommendedPlace(
        nameId = R.string.international_park_name,
        descriptionId = R.string.international_park_description,
        locationId = R.string.international_park_location,
        imageId = R.drawable.international_park,
        categoryType = CategoryType.PARKS
    )

    fun getPlaceData(): List<RecommendedPlace> {
        return listOf(

            RecommendedPlace(
                nameId = R.string.international_park_name,
                descriptionId = R.string.international_park_description,
                locationId = R.string.international_park_location,
                imageId = R.drawable.international_park,
                categoryType = CategoryType.PARKS
            ),

            RecommendedPlace(
                nameId = R.string.citystars_shopping_name,
                descriptionId = R.string.citystars_shopping_description,
                locationId = R.string.citystars_shopping_location,
                imageId = R.drawable.citystars_shopping,
                categoryType = CategoryType.SHOPPING
            ),

            RecommendedPlace(
                nameId = R.string.khan_elkhalili_shopping_name,
                descriptionId = R.string.khan_elkhalili_shopping_description,
                locationId = R.string.khan_elkhalili_shopping_location,
                imageId = R.drawable.khan_elkhalili_shopping,
                categoryType = CategoryType.SHOPPING
            ),

            RecommendedPlace(
                nameId = R.string.mall_of_egypt_shopping_name,
                descriptionId = R.string.mall_of_egypt_shopping_description,
                locationId = R.string.mall_of_egypt_shopping_location,
                imageId = R.drawable.mall_of_egypt_shopping,
                categoryType = CategoryType.SHOPPING
            ),

            RecommendedPlace(
                nameId = R.string.aqua_restaurant_name,
                descriptionId = R.string.aqua_restaurant_description,
                locationId = R.string.aqua_restaurant_location,
                imageId = R.drawable.aqua_restaurant,
                categoryType = CategoryType.RESTAURANTS
            ),

            RecommendedPlace(
                nameId = R.string.azhar_park_name,
                descriptionId = R.string.azhar_park_description,
                locationId = R.string.azhar_park_location,
                imageId = R.drawable.azhar_park,
                categoryType = CategoryType.PARKS
            ),

            RecommendedPlace(
                nameId = R.string.family_park_name,
                descriptionId = R.string.family_park_description,
                locationId = R.string.family_park_location,
                imageId = R.drawable.family_park,
                categoryType = CategoryType.PARKS
            ),

            RecommendedPlace(
                nameId = R.string.montaza_palace_park_name,
                descriptionId = R.string.montaza_palace_park_description,
                locationId = R.string.montaza_palace_park_location,
                imageId = R.drawable.montaza_palace_park,
                categoryType = CategoryType.PARKS
            ),

            RecommendedPlace(
                nameId = R.string.abou_tarek_restaurant_name,
                descriptionId = R.string.abou_tarek_restaurant_description,
                locationId = R.string.abou_tarek_restaurant_location,
                imageId = R.drawable.abou_tarek_restaurant,
                categoryType = CategoryType.RESTAURANTS
            ),

            RecommendedPlace(
                nameId = R.string.hawawshi_elrefaey_restaurant_name,
                descriptionId = R.string.hawawshi_elrefaey_restaurant_description,
                locationId = R.string.hawawshi_elrefaey_restaurant_location,
                imageId = R.drawable.hawawshi_elrefaey_restaurant,
                categoryType = CategoryType.RESTAURANTS
            ),
            // Arabiata Restaurant
            RecommendedPlace(
                nameId = R.string.arabiata_restaurant_name,
                descriptionId = R.string.arabiata_restaurant_description,
                locationId = R.string.arabiata_restaurant_location,
                imageId = R.drawable.arabiata_restaurant,
                categoryType = CategoryType.RESTAURANTS
            ),

            RecommendedPlace(
                nameId = R.string.the_white_dessert_tourism_name,
                descriptionId = R.string.the_white_dessert_tourism_description,
                locationId = R.string.the_white_dessert_tourism_location,
                imageId = R.drawable.the_white_dessert_tourism,
                categoryType = CategoryType.TOURISM
            ),

            RecommendedPlace(
                nameId = R.string.sakkara_pyramid_tourism_name,
                descriptionId = R.string.sakkara_pyramid_tourism_description,
                locationId = R.string.sakkara_pyramid_tourism_location,
                imageId = R.drawable.sakkara_pyramid_tourism,
                categoryType = CategoryType.TOURISM
            ),

            RecommendedPlace(
                nameId = R.string.mohamed_ali_mosque_tourism_name,
                descriptionId = R.string.mohamed_ali_mosque_tourism_description,
                locationId = R.string.mohamed_ali_mosque_tourism_location,
                imageId = R.drawable.mohamed_ali_mosque_tourism,
                categoryType = CategoryType.TOURISM
            ),

            RecommendedPlace(
                nameId = R.string.cairo_tower_tourism_name,
                descriptionId = R.string.cairo_tower_tourism_description,
                locationId = R.string.cairo_tower_tourism_location,
                imageId = R.drawable.cairo_tower_tourism,
                categoryType = CategoryType.TOURISM
            ),

            RecommendedPlace(
                nameId = R.string.old_cairo_tourism_name,
                descriptionId = R.string.old_cairo_tourism_description,
                locationId = R.string.old_cairo_tourism_location,
                imageId = R.drawable.old_cairo_tourism,
                categoryType = CategoryType.TOURISM
            ),

            RecommendedPlace(
                nameId = R.string.gezira_island_tourism_name,
                descriptionId = R.string.gezira_island_tourism_description,
                locationId = R.string.gezira_island_tourism_location,
                imageId = R.drawable.gezira_island_tourism,
                categoryType = CategoryType.TOURISM
            )
        )
    }
}
