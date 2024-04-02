package com.galaxy.evawiki.evainfo.presentation.item

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.galaxy.evawiki.evainfo.domain.usecases.ItemUseCases
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

    init {
        savedStateHandle.get<Int>("id")?.let {id->
            if(id != -1){
                viewModelScope.launch {
                    useCases.getCharacter(id).onRight { item->
                        _itemState.value = itemState.value.copy(item = item)
                    }.onLeft { error->
                        _itemState.value = itemState.value.copy(networkError = error)
                    }
                }
            }
        }
    }


}