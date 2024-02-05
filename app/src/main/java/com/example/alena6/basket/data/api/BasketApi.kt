package com.example.alena6.basket.data.api

import com.example.alena6.basket.domain.model.Account
import retrofit2.http.GET

interface BasketApi {
    @GET("/api/Accounts")
    suspend fun getParts(): List<Account>
}