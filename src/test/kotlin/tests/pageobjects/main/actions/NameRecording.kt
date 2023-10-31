package tests.pageobjects.main.actions

import actions.Action
import helpers.ApplicationContainer
import helpers.allureStep
import tests.pageobjects.main.SaveRecordingDialogWindow

class NameRecording(private val fileName: String) : Action {
    override fun go(application: ApplicationContainer) {
        allureStep("Нажимаем кнопку \"ok\" на диалоговом окне сохранения записи") {
            application.getPage(SaveRecordingDialogWindow::class).inputNameField.sendKeys(fileName)
        }
    }
}
