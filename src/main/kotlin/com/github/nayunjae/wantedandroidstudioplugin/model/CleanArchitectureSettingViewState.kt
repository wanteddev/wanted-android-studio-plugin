package com.github.nayunjae.wantedandroidstudioplugin.model

data class CleanArchitectureSettingViewState(
    var diEnable: Boolean,
    var remotePackageEnable: Boolean,
    var localPackageEnable: Boolean,
    var mapperEnable: Boolean,
    var apiPackageEnable: Boolean,
    var dataModelPackageEnable: Boolean,
    var dataRepositoryEnable: Boolean,
    var domainModelEnable: Boolean,
    var domainRepositoryEnable: Boolean,
    var useCaseEnable: Boolean,
    var uiPackageEnable: Boolean
)