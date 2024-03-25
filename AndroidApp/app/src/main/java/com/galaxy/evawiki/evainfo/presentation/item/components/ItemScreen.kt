package com.galaxy.evawiki.evainfo.presentation.item.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.galaxy.evawiki.evainfo.presentation.item.ItemViewModel

@Composable
fun ItemScreen(
    viewModel: ItemViewModel = hiltViewModel(),
){
    val state = viewModel.itemState.value
    state.item?.let { Text(text = it.fullName) }
}