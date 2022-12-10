package com.lnight.cryptocurrencyapp.data.remote

import com.lnight.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.lnight.cryptocurrencyapp.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}