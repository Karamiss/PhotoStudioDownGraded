package com.example.alena6.basket.domain

import com.example.alena6.basket.data.network.Resource
import com.example.alena6.basket.domain.model.Account
import kotlinx.coroutines.flow.Flow

interface BasketInteractor {
    fun getAccount() : Flow<Resource<List<Account>>>
}