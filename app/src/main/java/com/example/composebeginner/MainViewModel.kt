package com.example.composebeginner

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composebeginner.onboarding.DataStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: DataStoreRepository
) : ViewModel() {

    val allItems = createNamesList()

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
        if (textState.isEmpty()) {
            _dataItems.value = allItems
            return
        }

        val filteredList = mutableListOf<String>()
        allItems.forEach {
            if (it.lowercase().contains(textState.lowercase()))
                filteredList.add(it)
        }
        _dataItems.value = filteredList
        return
    }

    fun updateSearchWidgetState(widgetState: SearchWidgetState) {
        _searchWidgetState.value = widgetState
    }

    private val _dataItems: MutableState<List<String>> = mutableStateOf(allItems)
    val dataItems
        get() = _dataItems


    fun saveOnBoardingState(completed: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveOnBoardingState(completed)
        }
    }

}