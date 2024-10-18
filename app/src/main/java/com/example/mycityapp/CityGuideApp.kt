package com.example.mycityapp

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mycityapp.ui.CityGuideCategoriesScreen
import com.example.mycityapp.ui.CityGuidePlacesScreen
import com.example.mycityapp.ui.PlaceInfoScreen
import com.example.mycityapp.ui.CityGuideViewModel
import com.example.mycityapp.ui.PlacesListOnly
import com.example.mycityapp.ui.theme.MyCityAppTheme
import com.example.mycityapp.utils.CityGuideContentType

enum class CityGuideScreen(@StringRes val title: Int) {
    Categories(title = R.string.categories),
    Places(title = R.string.places),
    Details(title = R.string.details),
}

/**
 * Composable that displays the topBar and displays back button if back navigation is possible.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityGuideAppBar(
    currentScreen: CityGuideScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back)
                    )
                }
            }
        }
    )
}

@Composable
fun CityGuideApp(
    viewModel: CityGuideViewModel = viewModel(),
    navController: NavHostController = rememberNavController(),
    windowSize: WindowWidthSizeClass
) {
    val uiState by viewModel.uiState.collectAsState()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = CityGuideScreen.valueOf(
        backStackEntry?.destination?.route ?: CityGuideScreen.Categories.name
    )
    val contentType = when(windowSize){
        WindowWidthSizeClass.Compact, WindowWidthSizeClass.Medium-> {
            CityGuideContentType.ListOnly
        }
        WindowWidthSizeClass.Expanded -> {
            CityGuideContentType.ListAndDetails
        }
        else -> {
            CityGuideContentType.ListOnly
        }

    }


    Scaffold(topBar = {
        CityGuideAppBar(
            currentScreen = currentScreen,
            canNavigateBack = navController.previousBackStackEntry != null,
            navigateUp = { navController.navigateUp() }
        )
    })
    {
            innerPadding ->
        NavHost(
            navController = navController,
            startDestination = CityGuideScreen.Categories.name,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(route = CityGuideScreen.Categories.name) {
                CityGuideCategoriesScreen(
                    onCategoryClick = {
                        viewModel.updateCurrentCategory(it)
                        navController.navigate(CityGuideScreen.Places.name)
                    }
                )
            }

            composable(route = CityGuideScreen.Places.name) {
                CityGuidePlacesScreen(
                    viewModel = viewModel,
                    cityGuideContentType =contentType,
                    navController = navController,
                    onPlaceClick = {
                        viewModel.updateCurrentPlace(it)
                    }
                )
            }

            composable(route = CityGuideScreen.Details.name) {
                PlaceInfoScreen(
                    viewModel = viewModel)
            }

        }
    }

}

@Preview(showBackground = true, widthDp = 1000)
@Composable
fun CityGuidePreview() {
    MyCityAppTheme {
        CityGuideApp(windowSize = WindowWidthSizeClass.Expanded)
    }
}