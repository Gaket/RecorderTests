package tests.pageobjects

import com.codeborne.selenide.appium.SelenideAppium.`$`
import io.appium.java_client.AppiumBy

class MainPageObject {
    private val recordButton = `$`(AppiumBy.id("com.rimidalv.dictaphone:id/recPauseBtn"))


    fun clickRecordButton() {
        recordButton.click()
    }
}