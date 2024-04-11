package com.galaxy.evawiki.util

sealed interface Event {
    data class Toast(val message: String): Event
}