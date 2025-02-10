package di

import common.Context
import org.koin.dsl.module
import presentation.ui.main.home.view_model.HomeViewModel

fun appModule(context: Context) = module {
    factory { HomeViewModel() }
}
