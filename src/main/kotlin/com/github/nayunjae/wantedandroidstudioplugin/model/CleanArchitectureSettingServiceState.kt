package com.github.nayunjae.wantedandroidstudioplugin.model

import com.intellij.openapi.components.BaseState

class CleanArchitectureSettingServiceState : BaseState() {
    var diEnable by property(true)
    var remotePackageEnable by property(true)
    var localPackageEnable by property(true)
    var mapperEnable by property(true)
    var apiPackageEnable by property(true)
    var dataModelPackageEnable by property(true)
    var dataRepositoryEnable by property(true)
    var domainModelEnable by property(true)
    var domainRepositoryEnable by property(true)
    var useCaseEnable by property(true)
    var uiPackageEnable by property(true)
}

fun CleanArchitectureSettingServiceState.update(viewState: CleanArchitectureSettingViewState) {
    this.diEnable = viewState.diEnable
    this.remotePackageEnable = viewState.remotePackageEnable
    this.localPackageEnable = viewState.localPackageEnable
    this.mapperEnable = viewState.mapperEnable
    this.apiPackageEnable = viewState.apiPackageEnable
    this.dataModelPackageEnable = viewState.dataModelPackageEnable
    this.dataRepositoryEnable = viewState.dataRepositoryEnable
    this.domainModelEnable = viewState.domainModelEnable
    this.domainRepositoryEnable = viewState.domainRepositoryEnable
    this.useCaseEnable = viewState.useCaseEnable
    this.uiPackageEnable = viewState.uiPackageEnable
}

fun CleanArchitectureSettingServiceState.toViewState() = CleanArchitectureSettingViewState(
    this.diEnable,
    this.remotePackageEnable,
    this.localPackageEnable,
    this.mapperEnable,
    this.apiPackageEnable,
    this.dataModelPackageEnable,
    this.dataRepositoryEnable,
    this.domainModelEnable,
    this.domainRepositoryEnable,
    this.useCaseEnable,
    this.uiPackageEnable
)