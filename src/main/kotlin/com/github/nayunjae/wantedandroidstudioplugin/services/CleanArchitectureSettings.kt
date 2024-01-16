package com.github.nayunjae.wantedandroidstudioplugin.services

import com.github.nayunjae.wantedandroidstudioplugin.model.CleanArchitectureSettingServiceState
import com.github.nayunjae.wantedandroidstudioplugin.model.CleanArchitectureSettingViewState
import com.github.nayunjae.wantedandroidstudioplugin.model.toViewState
import com.github.nayunjae.wantedandroidstudioplugin.model.update
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.Service
import com.intellij.openapi.components.SimplePersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage

@Service
@State(
    name = "CleanArchitectureSettings",
    storages = [Storage("wanted_clean_architecture_persist.xml")]
)
class CleanArchitectureSettings :
    SimplePersistentStateComponent<CleanArchitectureSettingServiceState>(
        CleanArchitectureSettingServiceState()
    ) {
    var viewState: CleanArchitectureSettingViewState
        get() = super.getState().toViewState()
        set(value) = super.getState().update(value)

    companion object {
        fun getInstance(): CleanArchitectureSettings =
            ApplicationManager.getApplication().getService(CleanArchitectureSettings::class.java)
    }
}