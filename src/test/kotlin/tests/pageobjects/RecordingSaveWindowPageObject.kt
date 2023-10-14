package tests.pageobjects

import helpers.ApplicationContainer
import helpers.elementById

class RecordingSaveWindowPageObject(application: ApplicationContainer) : BasePageObject(application) {
    private val saveInputFileName = elementById("com.rimidalv.dictaphone:id/et_edit_name")
    private val saveSubmitButton = elementById("com.rimidalv.dictaphone:id/dialog_btn_ok")

    fun saveRecordingFile(fileName: String) {
        saveInputFileName.sendKeys(fileName)
        saveSubmitButton.click()
    }
}
