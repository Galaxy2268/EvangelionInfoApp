package com.galaxy.evawiki.evainfo.presentation.util

sealed class Screen(val route: String) {
    data object ItemsScreen: Screen("items_screen")
    data object ItemScreen: Screen("item_screen")
}