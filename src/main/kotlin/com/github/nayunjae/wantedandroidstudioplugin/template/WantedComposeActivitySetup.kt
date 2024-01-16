package com.github.nayunjae.wantedandroidstudioplugin.template

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor

fun RecipeExecutor.wantedComposeSetup(
    moduleData: ModuleTemplateData,
    name: String,
    packageName: String
) {
    val (_, srcOut, _) = moduleData

    println("[check]name = $name")
    println("[check]packageName = $packageName")
    save(composeScreen(packageName, name), srcOut.absoluteFile.resolve("${name}Screen.kt"))
    save(
        composeContract(packageName, name),
        srcOut.absoluteFile.resolve("${name}ScreenContract.kt")
    )
    save(composeViewModel(packageName, name), srcOut.absoluteFile.resolve("${name}ViewModel.kt"))
}


private fun composeScreen(packageName: String, name: String) = """
package $packageName

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.wanted.android.wanted.design.theme.DesignSystemTheme
import ${packageName}.${name}ScreenContract.${name}ViewEvent
import ${packageName}.${name}ScreenContract.${name}SideEffect
import ${packageName}.${name}ScreenContract.${name}ViewState

@Composable
fun ${name}Screen(
    modifier: Modifier,
    viewModel: ${name}ViewModel = hiltViewModel(),
    onClickBack: () -> Unit
) {
    val viewState = viewModel.viewState.collectAsStateWithLifecycle().value

    ${name}ScreenImpl(
        modifier = modifier,
        viewState = viewState
    ) { viewEvent ->
        when (viewEvent) {
            ${name}ViewEvent.OnClickBack -> onClickBack()
        }
    }
}

@Composable
private fun ${name}ScreenImpl(
    modifier: Modifier = Modifier,
    viewState: ${name}ViewState,
    onViewEvent: (${name}ViewEvent) -> Unit
) {

    Scaffold(
        modifier = modifier
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            
        }
    }
}

@Preview("light", uiMode = Configuration.UI_MODE_NIGHT_NO, locale = "ko")
@Preview("dark", uiMode = Configuration.UI_MODE_NIGHT_YES, locale = "ko")
@Preview(
    "foldableLight",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    locale = "ko",
    device = Devices.FOLDABLE
)
@Composable
private fun ${name}ScreenPreview() {
    DesignSystemTheme {
        ${name}ScreenImpl(
            viewState = ${name}ViewState(),
            onViewEvent = { }
        )
    }
}
""".trimIndent()

private fun composeContract(packageName: String, name: String) = """
package $packageName

import com.wanted.android.wanted.feature.base.presentation.BaseEvent
import com.wanted.android.wanted.feature.base.presentation.BaseSideEffect
import com.wanted.android.wanted.feature.base.presentation.BaseViewState
import com.wanted.android.wanted.feature.base.presentation.ViewEvent

object ${name}ScreenContract {
    sealed class ${name}Event : BaseEvent {
        data class InitState(val viewState: ${name}ViewState) : ${name}Event()
    }

    data class ${name}ViewState(
        val isLoading: Boolean = true,
    ) : BaseViewState

    object ${name}SideEffect : BaseSideEffect


    sealed class ${name}ViewEvent : ViewEvent {
        object OnClickBack : ${name}ViewEvent()
    }
}
"""

private fun composeViewModel(packageName: String, name: String) = """
package $packageName

import com.wanted.android.wanted.feature.base.presentation.WantedStateViewModel
import ${packageName}.${name}ScreenContract.${name}Event
import ${packageName}.${name}ScreenContract.${name}SideEffect
import ${packageName}.${name}ScreenContract.${name}ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ${name}ViewModel @Inject constructor(

) : WantedStateViewModel<${name}Event, ${name}ViewState, ${name}SideEffect>() {
    override fun setInitialState() = ${name}ViewState()

    override fun handleEvents(event: ${name}Event) {
        when (event) {
            is ${name}Event.InitState -> setState { event.viewState }
        }
    }

}
"""