package com.github.nayunjae.wantedandroidstudioplugin.template

import com.android.tools.idea.wizard.template.Category
import com.android.tools.idea.wizard.template.CheckBoxWidget
import com.android.tools.idea.wizard.template.Constraint
import com.android.tools.idea.wizard.template.FormFactor
import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.PackageNameWidget
import com.android.tools.idea.wizard.template.Separator
import com.android.tools.idea.wizard.template.TemplateData
import com.android.tools.idea.wizard.template.TextFieldWidget
import com.android.tools.idea.wizard.template.WizardUiContext
import com.android.tools.idea.wizard.template.booleanParameter
import com.android.tools.idea.wizard.template.impl.defaultPackageNameParameter
import com.android.tools.idea.wizard.template.stringParameter
import com.android.tools.idea.wizard.template.template
import com.github.nayunjae.wantedandroidstudioplugin.services.CleanArchitectureSettings

val cleanArchitectureTemplate
    get() = template {
        val savedState = CleanArchitectureSettings.getInstance().viewState

        name = "Wanted Clean Architecture Package"
        description = "원티드 클린 아키텍쳐 Package"
        minApi = 16
        category = Category.Other // Check other categories
        formFactor = FormFactor.Mobile
        screens = listOf(
            WizardUiContext.FragmentGallery, WizardUiContext.MenuEntry,
            WizardUiContext.NewProject, WizardUiContext.NewModule
        )

        val packageNameParam = defaultPackageNameParameter
        val featureName = stringParameter {
            name = "Feature Name"
            default = "Title"
            help = "Feature 이름"
            constraints = listOf(Constraint.NONEMPTY, Constraint.PACKAGE)
        }

        val diEnable = booleanParameter {
            name = "[Data] DI Package create"
            default = savedState.diEnable
            help = "DI 패키지 생성"
        }

        val remotePackageEnable = booleanParameter {
            name = "[Data] Remote Package create"
            default = savedState.remotePackageEnable
            help = "Remote Package 생성"
        }

        val localPackageEnable = booleanParameter {
            name = "[Data] Local Package create"
            default = savedState.localPackageEnable
            help = "Local Package 생성"
        }

        val mapperEnable = booleanParameter {
            name = "[Data] Mapper Package create"
            default = savedState.mapperEnable
            help = "Mapper Package 생성"
        }

        val apiPackageEnable = booleanParameter {
            name = "[Data] API Package create"
            default = savedState.apiPackageEnable
            help = "API Package 생성"
        }

        val dataModelPackageEnable = booleanParameter {
            name = "[Data] Model Package create"
            default = savedState.dataModelPackageEnable
            help = "Model Package 생성"
        }

        val dataRepositoryEnable = booleanParameter {
            name = "[Data] Repository Package create"
            default = savedState.dataRepositoryEnable
            help = "Repository Package 생성"
        }

        val domainModelEnable = booleanParameter {
            name = "[Domain] Model Package create"
            default = savedState.domainModelEnable
            help = "Model Package 생성"
        }

        val domainRepositoryEnable = booleanParameter {
            name = "[Domain] Model Repository create"
            default = savedState.domainRepositoryEnable
            help = "Model Repository 생성"
        }

        val useCaseEnable = booleanParameter {
            name = "[Domain] Usecase Package create"
            default = savedState.useCaseEnable
            help = "Usecase Package 생성"
        }

        val uiPackageEnable = booleanParameter {
            name = "[Presentation] Presentation Package create"
            default = savedState.uiPackageEnable
            help = "Presentation Package 생성"
        }

        widgets(
            TextFieldWidget(featureName),
            Separator,
            CheckBoxWidget(diEnable),
            CheckBoxWidget(remotePackageEnable),
            CheckBoxWidget(localPackageEnable),
            CheckBoxWidget(mapperEnable),
            CheckBoxWidget(apiPackageEnable),
            CheckBoxWidget(dataModelPackageEnable),
            CheckBoxWidget(dataRepositoryEnable),
            Separator,
            CheckBoxWidget(domainModelEnable),
            CheckBoxWidget(domainRepositoryEnable),
            CheckBoxWidget(useCaseEnable),
            Separator,
            CheckBoxWidget(uiPackageEnable),
            Separator,
            PackageNameWidget(packageNameParam)
        )

        recipe = { data: TemplateData ->
            val updatedViewState = savedState.copy(
                diEnable = diEnable.value,
                remotePackageEnable = remotePackageEnable.value,
                localPackageEnable = localPackageEnable.value,
                mapperEnable = mapperEnable.value,
                apiPackageEnable = apiPackageEnable.value,
                dataModelPackageEnable = dataModelPackageEnable.value,
                dataRepositoryEnable = dataRepositoryEnable.value,
                domainModelEnable = domainModelEnable.value,
                domainRepositoryEnable = domainModelEnable.value,
                useCaseEnable = useCaseEnable.value,
                uiPackageEnable = uiPackageEnable.value,
            )
            CleanArchitectureSettings.getInstance().viewState = updatedViewState
            wantedPackageSetup(
                data as ModuleTemplateData,
                featureName = featureName.value.lowercase(),
                state = updatedViewState,
                packageNameParam = packageNameParam.value
            )
        }
    }