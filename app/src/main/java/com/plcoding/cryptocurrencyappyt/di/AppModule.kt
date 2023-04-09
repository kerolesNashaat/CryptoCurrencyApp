package com.plcoding.cryptocurrencyappyt.di

import com.plcoding.cryptocurrencyappyt.data.remote.PaprikaApi
import com.plcoding.cryptocurrencyappyt.data.repository.PaprikaRepositoryImpl
import com.plcoding.cryptocurrencyappyt.domain.repository.PaprikaRepository
import com.plcoding.cryptocurrencyappyt.domain.usecases.getCoinByIdUseCase.GetCoinByIdUseCase
import com.plcoding.cryptocurrencyappyt.domain.usecases.getCoinsUseCase.GetCoinsUseCase
import com.plcoding.cryptocurrencyappyt.utilis.BASE_URL
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun providePaprikaApi(retrofit: Retrofit): PaprikaApi = retrofit.create(PaprikaApi::class.java)

    @Provides
    @Singleton
    fun providePaprikaRepository(paprikaApi: PaprikaApi): PaprikaRepository =
        PaprikaRepositoryImpl(paprikaApi)

    @Provides
    @Singleton
    fun provideGetCoinsUseCase(paprikaRepository: PaprikaRepository) =
        GetCoinsUseCase(paprikaRepository)

    @Provides
    @Singleton
    fun provideGetCoinByIdUseCase(paprikaRepository: PaprikaRepository) =
        GetCoinByIdUseCase(paprikaRepository)
}