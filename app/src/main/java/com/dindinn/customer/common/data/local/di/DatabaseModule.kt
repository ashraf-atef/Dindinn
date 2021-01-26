package com.dindinn.customer.common.data.local.di

import com.dindinn.customer.common.data.local.LocalDatabase
import org.koin.dsl.module

val databaseModule = module {
    single { LocalDatabase.getInstance(get()) }
}