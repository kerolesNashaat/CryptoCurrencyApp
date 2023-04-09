package com.plcoding.cryptocurrencyappyt.presentation.coinDetailScreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.cryptocurrencyappyt.domain.usecases.getCoinByIdUseCase.GetCoinByIdUseCase
import com.plcoding.cryptocurrencyappyt.utilis.COIN_ID_PARAM
import com.plcoding.cryptocurrencyappyt.utilis.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailVM @Inject constructor(
    private val getCoinByIdUseCase: GetCoinByIdUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var _state = mutableStateOf(CoinDetailStates())
    val state = _state

    init {
        savedStateHandle.get<String>(COIN_ID_PARAM)?.let {
            getCoinById(coinId = it)
        }
    }

    private fun getCoinById(coinId: String) {
        getCoinByIdUseCase.invoke(coinId).onEach { resource ->
            when (resource) {
                is Resource.Error -> _state.value = CoinDetailStates(
                    error = resource.message ?: "Unhandled Exception"
                )
                is Resource.Loading -> _state.value = CoinDetailStates(isLoading = true)
                is Resource.Success -> _state.value =
                    CoinDetailStates(coinDetail = resource.data)
            }
        }.launchIn(viewModelScope)
    }
}