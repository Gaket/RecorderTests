package tests.pageobjects

import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.appium.SelenideAppiumElement
import helpers.*
import kotlin.time.Duration

class RecordingPageObject(application: ApplicationContainer) : BasePageObject(application) {
    private val timer = elementById("com.rimidalv.dictaphone:id/time")
    private val recordStopButton = elementById("com.rimidalv.dictaphone:id/btnStop")

    fun clickStopRecording() {
        recordStopButton.click()
    }

    fun saveRecordingWindowTitle(): SelenideAppiumElement {
        return elementById("com.rimidalv.dictaphone:id/dialog_title")
    }

    fun checkUiTimeInProgress(duration: Duration) {
        val startTimeInSeconds = convertTimeToInt(timer.text)
        val expectedEndTime = secondsToUiTime(startTimeInSeconds + duration.inWholeSeconds.toInt())
        timer.shouldHave(text(expectedEndTime), convertKotlinSecondsToJava(duration))
    }
}
