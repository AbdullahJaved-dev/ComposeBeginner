package com.example.composebeginner.onboarding

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composebeginner.animatedsplash.MainScreens
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


class SplashViewModel @Inject constructor(
    private val repository: DataStoreRepository
) : ViewModel() {

    private val _isLoading: MutableState<Boolean> =
        mutableStateOf(true)

    val isLoading: State<Boolean>
        get() = _isLoading

    private val _startDestination: MutableState<String> =
        mutableStateOf(MainScreens.Splash.route)

    val startDestination: State<String>
        get() = _startDestination

    init {
        viewModelScope.launch {
            repository.readOnBoardingState().collect { completed ->
                if (completed)
                    _startDestination.value = MainScreens.Home.route
                else
                    _startDestination.value = MainScreens.Splash.route
            }
            _isLoading.value = false
        }
    }
}