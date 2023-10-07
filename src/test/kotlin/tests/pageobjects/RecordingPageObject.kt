package tests.pageobjects

import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.appium.SelenideAppiumElement
import helpers.convertKotlinSecondsToJava
import helpers.convertTimeToInt
import helpers.element
import helpers.secondsToUiTime
import kotlin.time.Duration

class RecordingPageObject {
    private val timer = element("com.rimidalv.dictaphone:id/time")
    private val recordStopButton = element("com.rimidalv.dictaphone:id/btnStop")

    fun clickStopRecording() {
        recordStopButton.click()
    }

    fun saveRecordingWindowTitle(): SelenideAppiumElement {
        return element("com.rimidalv.dictaphone:id/dialog_title")
    }

    fun checkUiTimeInProgress(duration: Duration) {
        val startTimeInSeconds = convertTimeToInt(timer.text)
        val expectedEndTime = secondsToUiTime(startTimeInSeconds + duration.inWholeSeconds.toInt())
        timer.shouldHave(text(expectedEndTime), convertKotlinSecondsToJava(duration))
    }
}
