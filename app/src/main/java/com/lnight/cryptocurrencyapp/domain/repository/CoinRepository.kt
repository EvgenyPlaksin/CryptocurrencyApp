package com.lnight.cryptocurrencyapp.domain.repository

import com.lnight.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.lnight.cryptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoints(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}