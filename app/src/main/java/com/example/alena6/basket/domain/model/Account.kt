package com.example.alena6.basket.domain.model

import android.os.Parcelable
import com.example.alena6.magazine.domen.model.ItemModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class Account (
    val id: String,
    val username: String,
    val password: String
): Parcelable

