package com.example.alena6.magazine.domen.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemModel(
    val photoUrl: Int,
    val title: String
): Parcelable



var itemModel = ArrayList<ItemModel>()


