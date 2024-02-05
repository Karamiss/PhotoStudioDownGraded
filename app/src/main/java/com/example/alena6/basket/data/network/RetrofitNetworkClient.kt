package com.example.alena6.basket.data.network

import com.example.alena6.basket.data.api.BasketApi
import com.example.alena6.basket.data.dto.BasketResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RetrofitNetworkClient(
    private val Service: BasketApi,
) : NetworkClient {
    override suspend fun doRequest(): Response {

        return withContext(Dispatchers.IO) {
            val response = BasketResponse(Service.getParts())
            try {
                response.apply { resultCode = 200 }
            } catch (e: Throwable) {
                Response().apply { resultCode = 500 }
            }
        }
    }
}

