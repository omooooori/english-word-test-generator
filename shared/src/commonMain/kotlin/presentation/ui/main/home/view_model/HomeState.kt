package presentation.ui.main.home.view_model

import business.core.NetworkState
import business.core.ProgressBarState
import business.core.ViewState
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

data class HomeState(
    val time: LocalDateTime = Clock.System.now().toLocalDateTime(TimeZone.UTC),
    val progressBarState: ProgressBarState = ProgressBarState.Idle,
    val networkState: NetworkState = NetworkState.Good,
) : ViewState
