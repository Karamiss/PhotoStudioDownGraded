package com.example.alena6.basket.data.network

import com.example.alena6.basket.domain.ErrorType


sealed class Resource<T>(val data: T? = null, val message: ErrorType? = null) {
    class Success<T>(data: T): Resource<T>(data)
    class Error<T>(message: ErrorType?, data: T? = null): Resource<T>(data, message)
}