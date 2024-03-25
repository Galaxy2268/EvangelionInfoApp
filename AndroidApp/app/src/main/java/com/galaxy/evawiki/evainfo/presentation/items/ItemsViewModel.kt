package com.galaxy.evawiki.evainfo.presentation.items

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.galaxy.evawiki.evainfo.domain.usecases.ItemUseCases
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


    private fun getCharacters(){
        viewModelScope.launch {
            useCases.getCharacters().onRight {characters->
                _state.value = state.value.copy(items = characters)
            }.onLeft {networkError->
                _state.value = state.value.copy(error = networkError)
            }
        }
    }

}