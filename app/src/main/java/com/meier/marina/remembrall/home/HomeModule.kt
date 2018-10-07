package com.meier.marina.remembrall.home

import com.meier.marina.base.Navigator
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext

val homeModule: Module = applicationContext {
    bean { HomeNavigator() as Navigator }
}
