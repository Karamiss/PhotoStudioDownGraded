package com.example.alena6.basket.domain.impl

import com.example.alena6.basket.data.BasketRepository
import com.example.alena6.basket.data.network.Resource
import com.example.alena6.basket.domain.BasketInteractor
import com.example.alena6.basket.domain.model.Account
import kotlinx.coroutines.flow.Flow

class BasketInteractorImpl(private val repository: BasketRepository) : BasketInteractor {
    override fun getAccount(): Flow<Resource<List<Account>>> {
        return repository.getBasket()
    }
}