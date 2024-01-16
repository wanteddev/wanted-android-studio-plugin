package com.github.nayunjae.wantedandroidstudioplugin.template

import com.android.tools.idea.wizard.template.Category
import com.android.tools.idea.wizard.template.Constraint
import com.android.tools.idea.wizard.template.FormFactor
import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.PackageNameWidget
import com.android.tools.idea.wizard.template.Separator
import com.android.tools.idea.wizard.template.TemplateData
import com.android.tools.idea.wizard.template.TextFieldWidget
import com.android.tools.idea.wizard.template.WizardUiContext
import com.android.tools.idea.wizard.template.impl.defaultPackageNameParameter
import com.android.tools.idea.wizard.template.stringParameter
import com.android.tools.idea.wizard.template.template

val composeTemplate
    get() = template {
        name = "Wanted Compose"
        description = "원티드 Compose"
        minApi = 16
        category = Category.Compose // Check other categories
        formFactor = FormFactor.Mobile
        screens = listOf(
            WizardUiContext.FragmentGallery, WizardUiContext.MenuEntry,
            WizardUiContext.NewProject, WizardUiContext.NewModule
        )

        val packageNameParam = defaultPackageNameParameter
        val name = stringParameter {
            name = "Screen Name"
            default = "Title"
            help = "Screen Name"
            constraints = listOf(Constraint.NONEMPTY, Constraint.PACKAGE)
        }

        widgets(
            TextFieldWidget(name),
            Separator,
            PackageNameWidget(packageNameParam)
        )

        recipe = { data: TemplateData ->
            wantedComposeSetup(
                data as ModuleTemplateData,
                name.value.replaceFirstChar { it.uppercase() },
                packageNameParam.value
            )
        }
    }