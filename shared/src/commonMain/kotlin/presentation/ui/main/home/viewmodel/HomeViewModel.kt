package presentation.ui.main.home.viewmodel

import business.core.BaseViewModel

class HomeViewModel() : BaseViewModel<HomeEvent, HomeState, Nothing>() {
    override fun setInitialState(): HomeState {
        return HomeState()
    }

    override fun onTriggerEvent(event: HomeEvent) {
    }
}
