package com.meier.marina.data

import androidx.room.Room
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.applicationContext

val dataModule = applicationContext {

    bean {
        Room.databaseBuilder(androidApplication(), Database::class.java, "remembrall-db")
            .build()
    }

    bean { get<Database>().remembrallDAO() }
}
