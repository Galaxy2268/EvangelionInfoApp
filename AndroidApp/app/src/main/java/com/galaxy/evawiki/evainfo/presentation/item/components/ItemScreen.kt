package com.galaxy.evawiki.evainfo.presentation.item.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.galaxy.evawiki.evainfo.domain.model.Item
import com.galaxy.evawiki.evainfo.presentation.item.ItemViewModel
import com.galaxy.evawiki.evainfo.presentation.item.components.fullcards.AngelFullCard
import com.galaxy.evawiki.evainfo.presentation.item.components.fullcards.CharacterFullCard
import com.galaxy.evawiki.evainfo.presentation.item.components.fullcards.EpisodeFullCard
import com.galaxy.evawiki.evainfo.presentation.item.components.fullcards.EvangelionFullCard
import com.galaxy.evawiki.evainfo.presentation.item.components.fullcards.StuffFullCard

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
            AngelFullCard(
                angel = state.item,
                modifier = Modifier.padding(16.dp)
            )
        }
        is Item.Episode -> {
            EpisodeFullCard(
                episode = state.item,
                modifier = Modifier.padding(16.dp)
            )
        }
        is Item.Evangelion -> {
            EvangelionFullCard(
                evangelion = state.item,
                modifier = Modifier.padding(16.dp)
            )
        }
        is Item.Stuff -> {
            StuffFullCard(
                stuff = state.item,
                modifier = Modifier.padding(16.dp)
            )
        }
        null -> Text(text = "ERROR")
    }
}