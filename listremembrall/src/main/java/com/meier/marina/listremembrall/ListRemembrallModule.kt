package com.meier.marina.listremembrall

import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext

val listRemembrallModule: Module = applicationContext {
    viewModel { RemembrallListViewModel(get()) }
}
