package tests.smoke.general

import org.junit.jupiter.api.Test
import tests.BaseTest
import tests.pageobjects.MainPageObject
import tests.pageobjects.RecordingPageObject
import kotlin.random.Random
import kotlin.time.Duration.Companion.seconds

class TestTimerWhenRecordingIsOn : BaseTest() {
    @Test
    fun test() {
        val waitTime = Random.nextInt(5, 76)
        val mainPageObject = MainPageObject()
        mainPageObject.clickRecordButton()
        RecordingPageObject().checkUiTimeInProgress(waitTime.seconds)
    }
}