plugins {
    alias(libs.plugins.yarutan.kotlinMultiplatform)
    alias(libs.plugins.yarutan.shared)
    alias(libs.plugins.ktlint)
}

ktlint {
    filter {
        exclude { it.file.path.contains("generated") }
    }
}

kotlin {
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonTest { dependencies {} }
        commonMain { dependencies {} }
        androidMain { dependencies {} }
        iosMain { dependencies {} }
    }
}
