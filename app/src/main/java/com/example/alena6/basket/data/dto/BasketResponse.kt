package com.example.alena6.basket.data.dto

import com.example.alena6.basket.data.network.Response
import com.example.alena6.basket.domain.model.Account

class BasketResponse(val results: List<Account>): Response()
