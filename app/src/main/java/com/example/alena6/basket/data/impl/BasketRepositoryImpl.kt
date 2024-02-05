package com.example.alena6.basket.data.impl

import com.example.alena6.basket.data.BasketRepository
import com.example.alena6.basket.data.dto.BasketResponse
import com.example.alena6.basket.data.network.NetworkClient
import com.example.alena6.basket.data.network.Resource
import com.example.alena6.basket.domain.ErrorType
import com.example.alena6.basket.domain.model.Account
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class BasketRepositoryImpl(private val networkClient: NetworkClient) : BasketRepository {
    override fun getBasket(): Flow<Resource<List<Account>>> = flow {
        try {
            val response = networkClient.doRequest()
            when (response.resultCode) {
                -1 -> {
                    emit(Resource.Error(ErrorType.CONNECTION_ERROR))
                }
                200 -> {
                    val partsList = (response as BasketResponse).results
                    emit(Resource.Success(partsList))
                }
                else -> {

                }
            }
        } catch (error: Error) {
            throw Exception(error)
        }
    }
}