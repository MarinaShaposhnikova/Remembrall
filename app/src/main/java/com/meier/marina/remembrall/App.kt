package com.meier.marina.remembrall

import android.app.Application
import com.meier.marina.data.dataModule
import com.meier.marina.listremembrall.listRemembrallModule
import com.meier.marina.remembrall.home.homeModule
import org.koin.android.ext.android.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(dataModule, homeModule, listRemembrallModule))
    }
}
