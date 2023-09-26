package tests.smoke.general

import com.codeborne.selenide.Condition
import io.github.serpro69.kfaker.Faker
import io.qase.api.annotation.QaseTitle
import org.junit.jupiter.api.Test
import tests.BaseTest
import tests.pageobjects.ListOfRecordingsPageObject
import tests.pageobjects.MainPageObject
import tests.pageobjects.RecordingPageObject
import tests.pageobjects.RecordingSaveWindowPageObject
import kotlin.random.Random
import kotlin.time.Duration.Companion.seconds

class TestTimerWhenRecordingIsOn : BaseTest() {
    @QaseTitle("REC-1")
    @Test
    fun recordingIsDisplayedInTheListOfRecordsListAfterSaving(){
        val fake = Faker()
        val fileName = fake.random.randomString(1, 10)
        val mainPageObject = MainPageObject()
        val waitTime = Random.nextInt(5, 10)

        mainPageObject.clickRecordButton()
        RecordingPageObject().checkUiTimeInProgress(waitTime.seconds)
        RecordingPageObject().clickStopRecording()
        RecordingPageObject().saveRecordingWindowTitle().shouldBe(Condition.visible)
        RecordingSaveWindowPageObject().saveRecordingFile(fileName)
        ListOfRecordingsPageObject().fileNameTitle().should(Condition.have(Condition.text(fileName)))
    }
}