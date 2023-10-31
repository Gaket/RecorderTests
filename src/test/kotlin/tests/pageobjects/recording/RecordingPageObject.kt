package tests.pageobjects.recording

import com.codeborne.selenide.Condition.text
import config.EnvironmentConfig.TIME_TOLERANCE
import helpers.*
import tests.pageobjects.BasePageObject
import kotlin.time.Duration

class RecordingPageObject(application: ApplicationContainer) : BasePageObject(application) {
    val timer = elementById("com.rimidalv.dictaphone:id/time")
    val stopRecordingButton = elementById("com.rimidalv.dictaphone:id/btnStop")
    val pauseRecordingButton = elementById("com.rimidalv.dictaphone:id/recPauseBtn")

    fun checkUiTimeInProgress(duration: Duration, timeTolerance: Duration = TIME_TOLERANCE) {
        val startTimeInSeconds = convertTimeToInt(timer.text)
        val expectedEndTime = secondsToUiTime(startTimeInSeconds + duration.inWholeSeconds.toInt())
        timer.shouldHave(text(expectedEndTime), convertKotlinSecondsToJava(duration + timeTolerance))
    }
}
