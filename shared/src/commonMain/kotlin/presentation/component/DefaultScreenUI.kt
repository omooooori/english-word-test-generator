package presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import business.core.NetworkState
import business.core.ProgressBarState
import business.core.Queue
import business.core.UIComponent
import business.core.ViewSingleAction
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

@Composable
fun DefaultScreenUI(
    errors: Flow<UIComponent> = MutableSharedFlow(),
    progressBarState: ProgressBarState = ProgressBarState.Idle,
    networkState: NetworkState = NetworkState.Good,
    onTryAgain: () -> Unit = {},
    titleToolbar: String? = null,
    startIconToolbar: ImageVector? = null,
    endIconToolbar: ImageVector? = null,
    onClickStartIconToolbar: () -> Unit = {},
    onClickEndIconToolbar: () -> Unit = {},
    content: @Composable () -> Unit,
) {
    val errorQueue = remember { mutableStateOf<Queue<UIComponent>>(Queue(mutableListOf())) }

    Scaffold(
        topBar = {
            if (titleToolbar != null) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    if (startIconToolbar != null) {

                    }
                    Text(titleToolbar, style = MaterialTheme.typography.titleLarge)

                    if (endIconToolbar != null) {

                    }
                }
            }
        }
    ) {
        Box(
            modifier = Modifier.padding(top = it.calculateTopPadding())
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            content()
            LaunchedEffect(errors) {
                errors.collect { errors ->
                    errorQueue.appendToMessageQueue(errors)
                }
            }

            // process the queue
            if (!errorQueue.value.isEmpty()) {
                errorQueue.value.peek()?.let { uiComponent ->
                    if (uiComponent is UIComponent.Dialog) {

                    }
                    if (uiComponent is UIComponent.ToastSimple) {

                    }
                }
            }

            if (networkState == NetworkState.Failed && progressBarState == ProgressBarState.Idle) {
            }

            if (progressBarState is ProgressBarState.LoadingWithLogo) {
            }

            if (progressBarState is ProgressBarState.ScreenLoading || progressBarState is ProgressBarState.FullScreenLoading) {
                CircularProgressIndicator()
            }
        }
    }
}


private fun MutableState<Queue<UIComponent>>.appendToMessageQueue(uiComponent: UIComponent) {
    if (uiComponent is UIComponent.None) {
        println("appendToMessageQueue:  ${uiComponent.message}")
        return
    }

    val queue = this.value
    queue.add(uiComponent)

    this.value = Queue(mutableListOf())
    this.value = queue
}

private fun MutableState<Queue<UIComponent>>.removeHeadMessage() {
    if (this.value.isEmpty()) {
        println("removeHeadMessage: Nothing to remove from DialogQueue")
        return
    }
    val queue = this.value
    queue.remove()
    this.value = Queue(mutableListOf())
    this.value = queue
}
