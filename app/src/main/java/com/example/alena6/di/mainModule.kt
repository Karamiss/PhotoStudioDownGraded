package com.example.alena6.di

import android.annotation.SuppressLint
import com.example.alena6.basket.data.BasketRepository
import com.example.alena6.basket.data.api.BasketApi
import com.example.alena6.basket.data.impl.BasketRepositoryImpl
import com.example.alena6.basket.data.network.NetworkClient
import com.example.alena6.basket.data.network.RetrofitNetworkClient
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit.GsonConverterFactory
import retrofit2.Converter

import retrofit2.Retrofit
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

val mainModule = module {
    single<BasketRepository> { BasketRepositoryImpl(get()) }
    single<NetworkClient> { RetrofitNetworkClient(get()) }
//    single<BasketInteractor> { BasketInteractorImpl(get()) }
    single<BasketApi> {
        Retrofit.Builder()
            .baseUrl("https://10.0.2.2:7001")
            .addConverterFactory(GsonConverterFactory.create() as Converter.Factory)
            .client(get())
            .build()
            .create(BasketApi::class.java)
    }

    single<OkHttpClient>{
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .sslSocketFactory(get(), get<Array<TrustManager>>()[0] as X509TrustManager)
            .hostnameVerifier { _, _ -> true }
            .build()
    }

    single<HttpLoggingInterceptor>{
        HttpLoggingInterceptor().also{
            it.level = HttpLoggingInterceptor.Level.BODY
        }
    }

    single<SSLSocketFactory>{get<SSLContext>().socketFactory}

    single<SSLContext>{
        SSLContext.getInstance("SSL").also {
            it.init(null, get<Array<TrustManager>>(), SecureRandom())
        }
    }

    single<Array<TrustManager>>{
        arrayOf<TrustManager>(@SuppressLint("CustomX509TrustManager")
        object : X509TrustManager {
            @SuppressLint("TrustAllX509TrustManager")
            override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) {}

            @SuppressLint("TrustAllX509TrustManager")
            override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {}

            override fun getAcceptedIssuers(): Array<X509Certificate> {
                return arrayOf()
            }
        })
    }


}