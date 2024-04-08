package com.galaxy.evawiki.evainfo.presentation.item.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.galaxy.evawiki.evainfo.domain.model.Item
import com.galaxy.evawiki.evainfo.domain.usecases.util.ItemType
import com.galaxy.evawiki.evainfo.presentation.item.ItemViewModel

@Composable
fun ItemScreen(
    viewModel: ItemViewModel = hiltViewModel(),
){
    viewModel.getItem(ItemType.CharacterType)
    val state = viewModel.itemState.value

    when(state.item){
        is Item.Character -> {
            Text(text = state.item.fullName)
        }
        else -> {
            //TODO
        }
    }
}