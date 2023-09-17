package tests.smoke.general

import com.codeborne.selenide.Condition
import io.github.serpro69.kfaker.Faker
import org.junit.jupiter.api.Test
import tests.BaseTest
import tests.pageobjects.ListOfRecordingsPageObject
import tests.pageobjects.MainPageObject
import tests.pageobjects.RecordingPageObject
import tests.pageobjects.RecordingSaveWindowPageObject
import kotlin.random.Random
import kotlin.time.Duration.Companion.seconds

class TestTimerWhenRecordingIsOn : BaseTest() {

    @Test
    fun recordingIsDisplayedInTheListOfRecordsListAfterSaving(){
        val fake = Faker()
        val fileName = fake.random.randomString(1, 10)
        val mainPageObject = MainPageObject()
        val recordingSaveWindow = RecordingSaveWindowPageObject()
        val recorderPageObject = RecordingPageObject()
        val listOfRecordings = ListOfRecordingsPageObject()
        val waitTime = Random.nextInt(5, 10)
        mainPageObject.clickRecordButton()
        RecordingPageObject().checkUiTimeInProgress(waitTime.seconds)
        recorderPageObject.clickStopRecording()
        recordingSaveWindow.saveRecordingFile(fileName)
        listOfRecordings.getFileNameTile().should(Condition.have(Condition.text(fileName)))
    }
}
