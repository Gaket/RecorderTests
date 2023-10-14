package tests.pageobjects

import com.codeborne.selenide.Condition
import helpers.ApplicationContainer
import helpers.elementById

class ListOfRecordingsPageObject(application: ApplicationContainer) : BasePageObject(application) {

    private val seekBar = elementById("com.rimidalv.dictaphone:id/seekBar")
    private val playRecordButton = elementById("com.rimidalv.dictaphone:id/row_img_play")
    private val fileNameTitle = elementById("com.rimidalv.dictaphone:id/row_file_name")

    fun checkFileNameTitle(fileName: String) {
        fileNameTitle.should(Condition.have(Condition.text(fileName)))
    }
}
