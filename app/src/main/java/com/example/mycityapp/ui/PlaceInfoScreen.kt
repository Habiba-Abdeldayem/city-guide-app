package com.example.mycityapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycityapp.model.RecommendedPlace
import com.example.mycityapp.ui.theme.MyCityAppTheme
import com.example.mycityapp.utils.CityGuideContentType

//@Composable
//fun PlaceInfoScreenss(viewModel: CityGuideViewModel,
//                    cityGuideContentType: CityGuideContentType,
//                    onPlaceClick:(RecommendedPlace) -> Unit
//                           ) {
//    when(cityGuideContentType){
//        CityGuideContentType.ListOnly -> {
//            PlaceInfoScreen(viewModel)
//        }
//        CityGuideContentType.ListAndDetails -> {
//            PlacesAndDetails(viewModel = viewModel,onPlaceClick = onPlaceClick)
//        }
//        else -> {
//            PlaceInfoScreen(viewModel)
//
//        }
//    }
//
//}

@Composable
fun PlaceInfoScreen(viewModel: CityGuideViewModel,
                    modifier :Modifier = Modifier){
    val uiState by viewModel.uiState.collectAsState()
    Column(modifier = modifier
        .verticalScroll(rememberScrollState())) {
        Image(painter = painterResource(uiState.currentSelectedPlace.imageId),
            null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
            )
        Text(
            text = stringResource(uiState.currentSelectedPlace.nameId),
            style = MaterialTheme.typography.displayMedium
            )
        Row {
            Icon(Icons.Filled.Place,null,modifier = Modifier.size(20.dp))
            Text(
                text = stringResource(uiState.currentSelectedPlace.locationId),
                style = MaterialTheme.typography.labelLarge
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = stringResource(uiState.currentSelectedPlace.descriptionId),
            style = MaterialTheme.typography.bodyMedium
        )

    }
}



@Preview(showBackground = true, widthDp = 1000)
@Composable
fun DetailsScreenPreview(){
    MyCityAppTheme {
//        PlacesAndDetails(CityGuideViewModel())
    }
}