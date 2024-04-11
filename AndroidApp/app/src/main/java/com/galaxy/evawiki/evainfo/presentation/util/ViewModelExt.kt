package com.galaxy.evawiki.evainfo.presentation.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.galaxy.evawiki.util.EventBus
import kotlinx.coroutines.launch

fun ViewModel.sendEvent(event: Any){
    viewModelScope.launch{
        EventBus.sendEvent(event)
    }
}