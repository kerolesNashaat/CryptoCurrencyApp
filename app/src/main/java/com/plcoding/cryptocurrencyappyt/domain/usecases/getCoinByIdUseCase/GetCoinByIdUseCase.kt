package com.plcoding.cryptocurrencyappyt.domain.usecases.getCoinByIdUseCase

import com.plcoding.cryptocurrencyappyt.data.toCoinDetail
import com.plcoding.cryptocurrencyappyt.domain.model.CoinDetail
import com.plcoding.cryptocurrencyappyt.domain.repository.PaprikaRepository
import com.plcoding.cryptocurrencyappyt.utilis.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class GetCoinByIdUseCase @Inject constructor(
    private val paprikaRepository: PaprikaRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coinDetail = paprikaRepository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coinDetail))
        } catch (ex: Exception) {
            emit(Resource.Error<CoinDetail>(message = ex.localizedMessage ?: "Undefined Error"))
        }
    }
}