package com.galaxy.evawiki.evainfo.presentation.item

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.galaxy.evawiki.evainfo.domain.usecases.ItemUseCases
import com.galaxy.evawiki.evainfo.domain.usecases.util.ItemType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(
    private val useCases: ItemUseCases,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _itemState = mutableStateOf(ItemState())
    val itemState: State<ItemState> = _itemState


    init{
        val type = savedStateHandle.get<String>("type")?.let { typeMapper(it) }
        println("test")
        savedStateHandle.get<Int>("id")?.let {id->
            if(id != -1 && type != null){
                viewModelScope.launch {
                    useCases.getItem(type, id).onRight { item->
                        _itemState.value = itemState.value.copy(item = item)
                    }.onLeft { error->
                        _itemState.value = itemState.value.copy(networkError = error)
                    }
                }
            }
        }
    }

    private fun typeMapper(type: String): ItemType{
        return when(type){
            "CharacterType" -> ItemType.CharacterType
            "EvangelionType" -> ItemType.EvangelionType
            "EpisodeType" -> ItemType.EpisodeType
            "AngelType" -> ItemType.AngelType
            "StuffType" -> ItemType.StuffType
            else -> throw IllegalArgumentException("illegal type")
        }
    }






}