package com.example.alena6.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alena6.data.PostRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostRequestViewModel(
    private val repo: PostRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main
) : ViewModel() {

    fun postData(size: String, type: String) = viewModelScope.launch(dispatcher) {
        repo.postData(size, type)
    }
}