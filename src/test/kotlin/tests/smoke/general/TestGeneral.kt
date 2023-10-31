package tests.smoke.general

import actions.AssertAction
import com.codeborne.selenide.Condition.*
import io.github.serpro69.kfaker.Faker
import io.qase.api.annotation.QaseTitle
import org.junit.jupiter.api.Test
import tests.BaseTest
import tests.pageobjects.main.MainPageObject
import tests.pageobjects.main.SaveRecordingDialogWindow
import tests.pageobjects.main.actions.ClickRecordingButton
import tests.pageobjects.main.actions.NameRecording
import tests.pageobjects.main.actions.SaveRecording
import tests.pageobjects.recording.actions.CheckUITimeInProgress
import tests.pageobjects.recording.actions.ClickStopRecordingButton
import users.UnsubscribedUser
import kotlin.random.Random
import kotlin.time.Duration.Companion.seconds

class TestTimerWhenRecordingIsOn : BaseTest() {
    @QaseTitle("REC-1")
    @Test
    fun test() {
        val user = UnsubscribedUser(application)
        val fake = Faker()
        val fileName = fake.random.randomString(1, 10)
        val waitTime = Random.nextInt(35, 76).seconds

        user.execute(
            ClickRecordingButton(),
            CheckUITimeInProgress(waitTime),
            ClickStopRecordingButton(),
            AssertAction("Проверяем значение заголовка в диалоговом окне сохранения записи") {
                application.getPage(SaveRecordingDialogWindow::class).title.shouldHave(text("Edit record"))
            },
            NameRecording(fileName),
            SaveRecording(),
            AssertAction("Проверяем, что название последней записи соответствует $fileName") {
                application.getPage(MainPageObject::class).getRecordingByIndex(0).name.shouldHave(text(fileName))
            }
        )
    }
}
