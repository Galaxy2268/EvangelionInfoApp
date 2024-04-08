package com.galaxy.evawiki.evainfo.presentation.items

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.galaxy.evawiki.evainfo.domain.model.Item
import com.galaxy.evawiki.evainfo.domain.usecases.ItemUseCases
import com.galaxy.evawiki.evainfo.domain.usecases.util.ItemType
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
        when(event){
            is ItemsEvent.ToggleFilterSection ->{
                _state.value = state.value.copy(
                    isFilterSectionVisible = !state.value.isFilterSectionVisible
                )
            }
            is ItemsEvent.GetItems ->{
                if(event.itemType::class == state.value.currentItem::class) return

                when(event.itemType){
                    is ItemType.EvangelionType -> getEvangelions()
                    is ItemType.AngelType -> getAngels()
                    is ItemType.CharacterType -> getCharacters()
                    is ItemType.EpisodeType -> getEpisodes()
                    is ItemType.StuffType -> getStuff()
                }
            }
        }
    }



    private fun getCharacters(){
        viewModelScope.launch {
            _state.value = state.value.copy(currentItem = ItemType.CharacterType)
            useCases.getItems(ItemType.CharacterType).onRight { characters->
                _state.value = state.value.copy(items = characters)
            }.onLeft {networkError->
                _state.value = state.value.copy(error = networkError)
            }
        }
    }

    private fun getStuff(){
        viewModelScope.launch {
            _state.value = state.value.copy(currentItem = ItemType.StuffType)
            useCases.getItems(ItemType.StuffType).onRight { stuff->
                _state.value = state.value.copy(items = stuff)
            }.onLeft {networkError->
                _state.value = state.value.copy(error = networkError)
            }
        }
    }

    private fun getAngels(){
        viewModelScope.launch {
            _state.value = state.value.copy(currentItem = ItemType.AngelType)
            useCases.getItems(ItemType.AngelType).onRight { angels->
                _state.value = state.value.copy(items = angels)
            }.onLeft {networkError->
                _state.value = state.value.copy(error = networkError)
            }
        }
    }

    private fun getEpisodes(){
        viewModelScope.launch {
            _state.value = state.value.copy(currentItem = ItemType.EpisodeType)
            useCases.getItems(ItemType.EpisodeType).onRight { episodes->
                _state.value = state.value.copy(items = episodes)
            }.onLeft {networkError->
                _state.value = state.value.copy(error = networkError)
            }
        }
    }

    private fun getEvangelions(){
        viewModelScope.launch {
            _state.value = state.value.copy(currentItem = ItemType.EvangelionType)
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