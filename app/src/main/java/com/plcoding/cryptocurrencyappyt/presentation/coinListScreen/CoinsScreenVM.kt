package com.plcoding.cryptocurrencyappyt.presentation.coinListScreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.cryptocurrencyappyt.domain.usecases.getCoinsUseCase.GetCoinsUseCase
import com.plcoding.cryptocurrencyappyt.utilis.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinsScreenVM @Inject constructor(val getCoinsUseCase: GetCoinsUseCase) : ViewModel() {

    private var _state = mutableStateOf(CoinsScreenStates())
    val state: MutableState<CoinsScreenStates> = _state

    init {
        getCoins()
    }

    private fun getCoins() {
        getCoinsUseCase().onEach { resource ->
            when (resource) {
                is Resource.Error -> state.value =
                    CoinsScreenStates(error = resource.message ?: "Undefined error")
                is Resource.Loading -> state.value = CoinsScreenStates(isLoading = true)
                is Resource.Success ->
                    state.value = CoinsScreenStates(coins = resource.data ?: listOf())
            }
        }.launchIn(viewModelScope)
    }
}