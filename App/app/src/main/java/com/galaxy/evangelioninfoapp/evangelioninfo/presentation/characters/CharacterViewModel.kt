package com.galaxy.evangelioninfoapp.evangelioninfo.presentation.characters

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.galaxy.evangelioninfoapp.evangelioninfo.domain.usecases.characters.CharacterUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val useCases: CharacterUseCases
): ViewModel() {

    private val _state = mutableStateOf(CharactersState())
    val state: State<CharactersState> = _state

    init {
        getCharacters()
    }


    private fun getCharacters(){
        viewModelScope.launch {
            useCases.getCharacters().onRight {characters->
                _state.value = state.value.copy(characters = characters)
            }.onLeft {networkError->
                _state.value = state.value.copy(error = networkError)
            }
        }
    }

}