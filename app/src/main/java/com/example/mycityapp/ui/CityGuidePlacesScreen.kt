package com.example.mycityapp.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.mycityapp.CityGuideScreen
import com.example.mycityapp.model.RecommendedPlace
import com.example.mycityapp.ui.theme.MyCityAppTheme
import com.example.mycityapp.utils.CityGuideContentType

@Composable
fun CityGuidePlacesScreen(
    viewModel: CityGuideViewModel,
    cityGuideContentType: CityGuideContentType,
    onPlaceClick: (RecommendedPlace) -> Unit,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    when (cityGuideContentType) {
        CityGuideContentType.ListOnly -> {
            PlacesListOnly(viewModel = viewModel, onPlaceClick =
            {
                onPlaceClick(it)
                navController.navigate(CityGuideScreen.Details.name)
            })
        }

        CityGuideContentType.ListAndDetails -> {
            PlacesAndDetails(viewModel = viewModel, onPlaceClick = onPlaceClick)
        }

        else -> {
            PlaceInfoScreen(
                viewModel = viewModel
            )

        }
    }
}

@Composable
fun PlacesAndDetails(
    viewModel: CityGuideViewModel,
    onPlaceClick: (RecommendedPlace) -> Unit
) {

    Row(modifier = Modifier.fillMaxWidth()) {
        PlacesListOnly(
            viewModel = viewModel,
            onPlaceClick = onPlaceClick,
            modifier = Modifier.weight(1f)
        )
        PlaceInfoScreen(
            viewModel = viewModel,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun PlacesListOnly(
    viewModel: CityGuideViewModel,
    onPlaceClick: (RecommendedPlace) -> Unit,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()
    val categoryPlaces = uiState.currentCategoryPlaces

    LazyColumn(modifier = modifier) {
        items(categoryPlaces) {
            PlacesListCard(it, onPlaceClick)
        }

    }
}


@Composable
fun PlacesListCard(
    currentPlace: RecommendedPlace,
    onPlaceClick: (RecommendedPlace) -> Unit
) {
    Card(
        modifier = Modifier.padding(8.dp),
        onClick = { onPlaceClick(currentPlace) }

    ) {
        PlacesListItem(currentPlace.imageId, currentPlace.nameId)
    }
}

@Composable
fun PlacesListItem(@DrawableRes imageId: Int, @StringRes stringId: Int) {
    val itemImage = painterResource(imageId)
    val itemName = stringResource(stringId)
    Row(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = itemImage,
            contentDescription = null,
            modifier = Modifier.size(50.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = itemName,
            fontSize = 14.sp,

            )
    }
}

@Preview(showBackground = true)
@Composable
fun PlacesComposablePreview() {
    val viewModel: CityGuideViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

//    viewModel.updateCurrentCategory()

    MyCityAppTheme {
        PlacesListOnly(viewModel, {})
    }
}
