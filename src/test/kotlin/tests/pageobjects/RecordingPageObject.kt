package tests.pageobjects

import com.codeborne.selenide.Condition
import com.codeborne.selenide.appium.SelenideAppium.`$`
import helpers.convertKotlinSecondsToJava
import helpers.convertTimeToInt
import helpers.secondsToUiTime
import io.appium.java_client.AppiumBy
import kotlin.time.Duration

class RecordingPageObject {
    private val timer = `$`(AppiumBy.id("com.rimidalv.dictaphone:id/time"))
    private val recordStopButton = `$`(AppiumBy.id("com.rimidalv.dictaphone:id/btnStop"))

    fun clickStopRecording() {
        recordStopButton.click()
        val saveRecordingWindowTitle = `$`(AppiumBy.id("com.rimidalv.dictaphone:id/dialog_title"))
        saveRecordingWindowTitle.shouldBe(Condition.visible)
    }

    fun checkUiTimeInProgress(duration: Duration) {
        val startTimeInSeconds = convertTimeToInt(timer.text)
        val expectedEndTime = secondsToUiTime(startTimeInSeconds + duration.inWholeSeconds.toInt())
        timer.shouldHave(Condition.text(expectedEndTime), convertKotlinSecondsToJava(duration))
    }
}
