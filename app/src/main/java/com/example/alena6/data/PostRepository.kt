package com.example.alena6.data

import com.example.alena6.data.retrofit.PostService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


interface PostRepository {

    suspend fun postData(size: String, type: String)

}

class PostRepositoryImpl(
    private val service: PostService,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : PostRepository{

    override suspend fun postData(size: String, type: String) = withContext(dispatcher){
        service.sendData(size, type)
    }

}