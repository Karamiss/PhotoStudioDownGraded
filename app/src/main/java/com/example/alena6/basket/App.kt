package com.example.alena6.basket

import android.app.Application
import com.example.alena6.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App: Application() {

    override fun onCreate(){
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                mainModule
            )
        }


    }
}