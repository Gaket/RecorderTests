package tests.pageobjects

import helpers.element

class RecordingSaveWindowPageObject {
    private val saveInputFileName = element("com.rimidalv.dictaphone:id/et_edit_name")
    private val saveSubmitButton = element("com.rimidalv.dictaphone:id/dialog_btn_ok")

    fun saveRecordingFile(fileName: String) {
        saveInputFileName.sendKeys(fileName)
        saveSubmitButton.click()
    }
}
