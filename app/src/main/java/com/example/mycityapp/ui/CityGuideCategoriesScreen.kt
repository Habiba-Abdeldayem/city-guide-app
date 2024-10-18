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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycityapp.CityGuideScreen
import com.example.mycityapp.R
import com.example.mycityapp.data.CategoryType
import com.example.mycityapp.ui.theme.MyCityAppTheme
import java.util.Locale

@Composable
fun CityGuideCategoriesScreen(onCategoryClick: (CategoryType) -> Unit) {
    CategoriesListComposable(onCategoryClick=onCategoryClick)
}


@Composable
fun CategoriesListComposable(
    modifier: Modifier = Modifier,
    onCategoryClick: (CategoryType) -> Unit
)
{
    val namesList = CategoryType.entries.toMutableList()

    LazyColumn{
        items(namesList){
            CategoryListCard(it.image,it.displayName,onCategoryClick = onCategoryClick)
        }

    }
}

@Composable
fun CategoryListCard(
    @DrawableRes imageId:Int,
    @StringRes stringId: Int,
    onCategoryClick: (CategoryType) -> Unit)
{
    val name = stringResource(stringId).uppercase()
    val currentCategory = CategoryType.valueOf(name)

    Card(
        modifier = Modifier.padding(8.dp),
        onClick = {onCategoryClick(currentCategory)}
    ) {
        CategoriesListItem(imageId,stringId)
    }
}

@Composable
fun CategoriesListItem(@DrawableRes imageId:Int, @StringRes stringId: Int) {
    Row(
        modifier = Modifier.padding(4.dp).fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(imageId),
            contentDescription = null,
            modifier = Modifier.size(50.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = stringResource(stringId),
            fontSize = 14.sp,

        )
    }
}

@Preview(showBackground = true)
@Composable
fun ListComposablePreview(){
    MyCityAppTheme {

        CategoriesListComposable(onCategoryClick = {})
    }
}
