package tests.pageobjects

import com.codeborne.selenide.appium.SelenideAppium.`$`
import io.appium.java_client.AppiumBy

class RecordingSaveWindowPageObject {
    private val saveInputFileName = `$`(AppiumBy.id("com.rimidalv.dictaphone:id/et_edit_name"))
    private val saveSubmitButton = `$`(AppiumBy.id("com.rimidalv.dictaphone:id/dialog_btn_ok"))

    fun saveRecordingFile(fileName: String) {
        saveInputFileName.sendKeys(fileName)
        saveSubmitButton.click()
    }

}