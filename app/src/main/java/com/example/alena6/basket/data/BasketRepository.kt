package com.example.alena6.basket.data

import com.example.alena6.basket.data.network.Resource
import com.example.alena6.basket.domain.model.Account
import kotlinx.coroutines.flow.Flow

interface BasketRepository {
    fun getBasket() : Flow<Resource<List<Account>>>
}