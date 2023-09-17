package tests.pageobjects

import com.codeborne.selenide.Condition
import com.codeborne.selenide.appium.SelenideAppium.`$`
import io.appium.java_client.AppiumBy

class MainPageObject {
    private val recordButton = `$`(AppiumBy.id("com.rimidalv.dictaphone:id/recPauseBtn"))

    fun clickRecordButton() {
        recordButton.click()
        val recordingPageTitle = `$`(AppiumBy.id("com.rimidalv.dictaphone:id/textView2"))
        recordingPageTitle.shouldBe(Condition.visible)
    }
}