package di

import common.Context
import org.koin.dsl.module
import presentation.ui.main.home.viewmodel.HomeViewModel

fun appModule(context: Context) =
    module {
        factory { HomeViewModel() }
    }
