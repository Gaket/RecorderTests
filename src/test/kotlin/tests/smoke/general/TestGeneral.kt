package tests.smoke.general

import com.codeborne.selenide.Condition.*
import helpers.ApplicationContainer
import io.github.serpro69.kfaker.Faker
import io.qase.api.annotation.QaseTitle
import org.junit.jupiter.api.Test
import tests.BaseTest
import tests.pageobjects.ListOfRecordingsPageObject
import tests.pageobjects.main.MainPageObject
import tests.pageobjects.RecordingPageObject
import tests.pageobjects.RecordingSaveWindowPageObject
import tests.pageobjects.main.actions.ClickRecordButton
import users.UnsubscribedUser
import kotlin.random.Random
import kotlin.time.Duration.Companion.seconds

class TestTimerWhenRecordingIsOn : BaseTest() {
    @QaseTitle("REC-1")
    @Test
    fun test() {
        val application = ApplicationContainer()
        val user = UnsubscribedUser(application)
        val fake = Faker()
        val fileName = fake.random.randomString(1, 10)
        val mainPageObject = MainPageObject(application)
        val recordingPageObject = RecordingPageObject(application)
        val waitTime = Random.nextInt(5, 76)



        //mainPageObject.clickRecordButton()

        user.execute(
            ClickRecordButton()
        )

        mainPageObject.checkVisibilityOfTitle()
        recordingPageObject.checkUiTimeInProgress(waitTime.seconds)
        recordingPageObject.clickStopRecording()
        recordingPageObject.saveRecordingWindowTitle().shouldBe(visible)
        RecordingSaveWindowPageObject(application).saveRecordingFile(fileName)
        ListOfRecordingsPageObject(application).checkFileNameTitle(fileName)
    }
}
