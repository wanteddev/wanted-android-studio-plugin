package com.github.nayunjae.wantedandroidstudioplugin.template

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.github.nayunjae.wantedandroidstudioplugin.model.CleanArchitectureSettingViewState

fun RecipeExecutor.wantedPackageSetup(
    moduleData: ModuleTemplateData,
    featureName: String,
    state: CleanArchitectureSettingViewState,
    packageNameParam: String
) {
    val (_, srcOut, _) = moduleData

    println("[check]featureName = $featureName")
    println("packageNameParam : ${packageNameParam}")
    println("srcOut.absoluteFile : ${srcOut.absoluteFile}")
    println("(srcOut.absoluteFile.resolve : ${srcOut.absoluteFile.resolve(featureName)}/data/di")

    if (state.diEnable)
        createDirectory(srcOut.absoluteFile.resolve("${featureName}/data/di"))

    if (state.remotePackageEnable)
        createDirectory(srcOut.absoluteFile.resolve("${featureName}/data/remote/datasource"))

    if (state.localPackageEnable)
        createDirectory(srcOut.absoluteFile.resolve("${featureName}/data/local/datasource"))

    if (state.mapperEnable)
        createDirectory(srcOut.absoluteFile.resolve("${featureName}/data/local/mapper"))

    if (state.apiPackageEnable)
        createDirectory(srcOut.absoluteFile.resolve("${featureName}/data/remote/api"))

    if (state.dataModelPackageEnable) {
        createDirectory(srcOut.absoluteFile.resolve("${featureName}/data/model/request"))
        createDirectory(srcOut.absoluteFile.resolve("${featureName}/data/model/response"))
    }

    if (state.dataRepositoryEnable) {
        createDirectory(srcOut.absoluteFile.resolve("${featureName}/data/repository"))
    }

    if (state.domainModelEnable)
        createDirectory(srcOut.absoluteFile.resolve("${featureName}/domain/model"))

    if (state.domainRepositoryEnable)
        createDirectory(srcOut.absoluteFile.resolve("${featureName}/domain/repository"))

    if (state.useCaseEnable)
        createDirectory(srcOut.absoluteFile.resolve("${featureName}/domain/usecase"))

    if (state.uiPackageEnable)
        createDirectory(srcOut.absoluteFile.resolve("${featureName}/presentation/ui"))

}
