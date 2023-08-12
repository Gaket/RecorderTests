package tests.smoke.general

import org.junit.jupiter.api.Test
import tests.BaseTest
import tests.pageobjects.MainPageObject
import tests.pageobjects.RecordingPageObject
import kotlin.time.Duration.Companion.seconds

class TestLaunchApp : BaseTest() {
    @Test
    fun launchAppAndWait() {
        Thread.sleep(5000) //просто хардкод
    }
}


class TestStartRecording : BaseTest() {
    @Test
    fun testClickPes() {
        val mainPageObject = MainPageObject()
        mainPageObject.clickRecordButton()
        RecordingPageObject().checkUiTimeInProgress(12.seconds)
    }
}