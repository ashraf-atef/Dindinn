package com.dindinn.customer.common

import android.app.Application
import com.airbnb.mvrx.MvRx
import com.airbnb.mvrx.MvRxViewModelConfigFactory
import com.dindinn.customer.common.data.local.di.databaseModule
import com.dindinn.customer.common.data.remote.di.remoteModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class DindinnApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
        MvRx.viewModelConfigFactory = MvRxViewModelConfigFactory(applicationContext)
    }

    private fun initKoin() {
        startKoin() {
            androidContext(baseContext)
            androidLogger()
            modules(
                listOf(
                    databaseModule,
                    remoteModule
                )
            )
        }
    }
}