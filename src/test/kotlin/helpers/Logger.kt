package helpers

import io.qameta.allure.Allure
import java.io.File

internal fun allureStep(value: String, params: String = "", action: () -> Unit) {
    if (params.isEmpty()) {
        Allure.step(value) { ->
            action()
        }
    } else {
        Allure.step(value) { ->
            action()
        }
    }
}

internal fun attachFile(name: String, file: File, type: String, fileExtension: String) {
    Allure.addAttachment(name, type, file.inputStream(), fileExtension)
}

internal fun attachParams(name: String, content: String) {
    Allure.addAttachment(name, content)
}
