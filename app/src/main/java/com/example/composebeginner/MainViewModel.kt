package com.example.composebeginner

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel


class MainViewModel : ViewModel() {

    private val _searchWidgetState: MutableState<SearchWidgetState> =
        mutableStateOf(SearchWidgetState.CLOSED)

    val searchWidgetState: State<SearchWidgetState>
        get() = _searchWidgetState

    private val _searchTextState: MutableState<String> =
        mutableStateOf("")

    val searchTextState: State<String>
        get() = _searchTextState

    fun updateSearchTextState(textState: String) {
        _searchTextState.value = textState
    }

    fun updateSearchWidgetState(widgetState: SearchWidgetState) {
        _searchWidgetState.value = widgetState
    }

}