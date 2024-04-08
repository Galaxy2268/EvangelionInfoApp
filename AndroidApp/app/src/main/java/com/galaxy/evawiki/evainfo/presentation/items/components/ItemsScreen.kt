package com.galaxy.evawiki.evainfo.presentation.items.components

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Sort
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.galaxy.evawiki.evainfo.domain.model.Item
import com.galaxy.evawiki.evainfo.presentation.items.ItemsEvent
import com.galaxy.evawiki.evainfo.presentation.items.ItemsViewModel
import com.galaxy.evawiki.evainfo.presentation.util.Screen

@Composable
fun ItemsScreen(
    viewModel: ItemsViewModel = hiltViewModel(),
    navController: NavController
){
    val state = viewModel.state.value


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "EVA Wiki",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
            IconButton(
                onClick = {viewModel.onEvent(ItemsEvent.ToggleFilterSection)}
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.Sort,
                    contentDescription = "Filter"
                )
            }
        }
        
        AnimatedVisibility(
            visible = state.isFilterSectionVisible,
            enter = fadeIn() + slideInVertically(),
            exit = fadeOut() + slideOutVertically()
        ) {
            FilterSection(
                modifier = Modifier
                    .fillMaxWidth(),
                currentItem = state.currentItem,
                onChange = {
                    viewModel.onEvent(ItemsEvent.GetItems(it))
                }
            )
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        LazyVerticalStaggeredGrid(
            modifier = Modifier.fillMaxSize(),
            columns = StaggeredGridCells.Fixed(2),
            verticalItemSpacing = 8.dp,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(state.items) { item ->
                ItemsCard(
                    item = item,
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable {
                            val id = viewModel.getItemId(item)
                            Log.d("typeTest", "${state.currentItem}")
                            navController.navigate("${Screen.ItemScreen.route}?id=$id&type=${state.currentItem}")
                        }
                )

            }
        }


    }


}



