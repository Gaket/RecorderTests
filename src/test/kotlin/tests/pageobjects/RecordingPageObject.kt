package tests.pageobjects

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.appium.SelenideAppium
import helpers.convertTimeToInt
import helpers.secondsToUiTime
import io.appium.java_client.AppiumBy
import kotlin.time.Duration

class RecordingPageObject {
    val timer = SelenideAppium.`$`(AppiumBy.id("com.rimidalv.dictaphone:id/time"))

    fun checkUiTimeInProgress(duration: Duration) {
        val durationInSeconds = duration.inWholeSeconds
        val startTime = convertTimeToInt(timer.text)
        val expectedTimeAfterWaiting = secondsToUiTime(durationInSeconds.toInt() + startTime)
        Thread.sleep(durationInSeconds)
        timer.shouldHave(Condition.text(expectedTimeAfterWaiting))
    }
}