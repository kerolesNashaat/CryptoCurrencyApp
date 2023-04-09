package com.plcoding.cryptocurrencyappyt.domain.usecases.getCoinsUseCase

import com.plcoding.cryptocurrencyappyt.data.toCoin
import com.plcoding.cryptocurrencyappyt.domain.model.Coin
import com.plcoding.cryptocurrencyappyt.domain.repository.PaprikaRepository
import com.plcoding.cryptocurrencyappyt.utilis.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val paprikaRepository: PaprikaRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = paprikaRepository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch (ex: Exception) {
            emit(Resource.Error<List<Coin>>(message = ex.localizedMessage ?: "Undefined Error"))
        }
    }
}