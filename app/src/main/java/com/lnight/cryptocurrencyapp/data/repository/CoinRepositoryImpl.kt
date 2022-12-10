package com.lnight.cryptocurrencyapp.data.repository

import com.lnight.cryptocurrencyapp.data.remote.CoinPaprikaApi
import com.lnight.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.lnight.cryptocurrencyapp.data.remote.dto.CoinDto
import com.lnight.cryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository{
    override suspend fun getCoints(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}