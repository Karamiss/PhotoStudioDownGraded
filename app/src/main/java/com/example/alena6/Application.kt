package com.example.alena6

import android.app.Application
import com.example.alena6.data.PostRepositoryImpl
import com.example.alena6.data.retrofit.PostService
import com.example.alena6.viewmodel.PostRequestViewModel
import retrofit2.Retrofit

class MyApplication : Application() {

    lateinit var viewModel: PostRequestViewModel


    override fun onCreate() {
        super.onCreate()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.quotable.io")
            //.addConverterFactory(GsonConverterFactory.create())
            .build()

        viewModel = PostRequestViewModel(
            PostRepositoryImpl(
            retrofit.create(PostService::class.java)
        )
        )
    }
}