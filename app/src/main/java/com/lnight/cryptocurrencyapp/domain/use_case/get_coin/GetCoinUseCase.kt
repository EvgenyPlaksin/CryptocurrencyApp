package com.lnight.cryptocurrencyapp.domain.use_case.get_coin

import com.lnight.cryptocurrencyapp.common.Resource
import com.lnight.cryptocurrencyapp.data.remote.dto.toCoinDetail
import com.lnight.cryptocurrencyapp.domain.model.CoinDetail
import com.lnight.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
){
    operator fun invoke(id: String): Flow<Resource<CoinDetail>> = flow{
        try {
           emit(Resource.Loading<CoinDetail>())
            val coins = repository.getCoinById(id)
            emit(Resource.Success<CoinDetail>(coins.toCoinDetail()))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>("Couldn't reach server, check your internet connection"))
        }
    }
}