package com.galaxy.evawiki.evainfo.presentation.items

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.galaxy.evawiki.evainfo.domain.model.Item
import com.galaxy.evawiki.evainfo.domain.usecases.ItemUseCases
import com.galaxy.evawiki.evainfo.domain.usecases.util.ItemType
import com.galaxy.evawiki.evainfo.presentation.util.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemsViewModel @Inject constructor(
    private val useCases: ItemUseCases
): ViewModel() {

    private val _state = mutableStateOf(CharactersState())
    val state: State<CharactersState> = _state

    init {
        getCharacters()
    }

    fun onEvent(event: ItemsEvent){

    }




    private fun getCharacters(){
        viewModelScope.launch {
            useCases.getItems(ItemType.CharacterType).onRight { characters->
                _state.value = state.value.copy(items = characters)
            }.onLeft {networkError->
                _state.value = state.value.copy(error = networkError)
            }
        }
    }

    private fun getStuff(){
        viewModelScope.launch {
            useCases.getItems(ItemType.StuffType).onRight { stuff->
                _state.value = state.value.copy(items = stuff)
            }.onLeft {networkError->
                _state.value = state.value.copy(error = networkError)
            }
        }
    }

    private fun getAngels(){
        viewModelScope.launch {
            useCases.getItems(ItemType.AngelType).onRight { angels->
                _state.value = state.value.copy(items = angels)
            }.onLeft {networkError->
                _state.value = state.value.copy(error = networkError)
            }
        }
    }

    private fun getEpisodes(){
        viewModelScope.launch {
            useCases.getItems(ItemType.EpisodeType).onRight { episodes->
                _state.value = state.value.copy(items = episodes)
            }.onLeft {networkError->
                _state.value = state.value.copy(error = networkError)
            }
        }
    }

    private fun getEvangelions(){
        viewModelScope.launch {
            useCases.getItems(ItemType.EvangelionType).onRight { evangelions->
                _state.value = state.value.copy(items = evangelions)
            }.onLeft {networkError->
                _state.value = state.value.copy(error = networkError)
            }
        }
    }

    fun getItemId(item: Item): Int{
        return when (item) {
            is Item.Character -> item.pk
            is Item.Stuff -> item.pk
            is Item.Angel -> item.pk
            is Item.Episode -> item.pk
            is Item.Evangelion -> item.pk
        }
    }

}