package com.galaxy.evawiki.evainfo.presentation.item.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.galaxy.evawiki.evainfo.domain.model.Item
import com.galaxy.evawiki.evainfo.domain.usecases.util.ItemType
import com.galaxy.evawiki.evainfo.presentation.item.ItemViewModel

@Composable
fun ItemScreen(
    viewModel: ItemViewModel = hiltViewModel(),
){
    val state = viewModel.itemState.value

    when(state.item){
        is Item.Character -> {
            CharacterFullCard(
                character = state.item,
                modifier = Modifier.padding(16.dp)
            )
        }
        is Item.Angel -> {
            Text(text = state.item.name)
        }
        is Item.Episode -> {
            Text(text = state.item.name)
        }
        is Item.Evangelion -> {
            Text(text = state.item.name)
        }
        is Item.Stuff -> {
            Text(text = state.item.name)
        }
        null -> Text(text = "ERROR")
    }
}