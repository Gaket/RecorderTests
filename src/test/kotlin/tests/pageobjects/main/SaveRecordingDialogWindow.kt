package tests.pageobjects.main

import helpers.ApplicationContainer
import helpers.elementById
import tests.pageobjects.BasePageObject

class SaveRecordingDialogWindow(val application: ApplicationContainer) : BasePageObject(application) {
    /* TODO: Make this PO a part of MainPageObject once all the elements in the app have ID */
    val title = elementById("com.rimidalv.dictaphone:id/dialog_title")
    val inputNameField = elementById("com.rimidalv.dictaphone:id/et_edit_name")
    val submitButton = elementById("com.rimidalv.dictaphone:id/dialog_btn_ok")
}
