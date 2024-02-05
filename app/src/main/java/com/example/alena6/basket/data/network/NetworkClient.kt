package com.example.alena6.basket.data.network

interface NetworkClient {
    suspend fun doRequest(): Response
}