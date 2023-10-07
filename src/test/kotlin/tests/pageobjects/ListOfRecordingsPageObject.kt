package tests.pageobjects

import com.codeborne.selenide.Condition
import com.codeborne.selenide.appium.SelenideAppiumElement
import helpers.element

class ListOfRecordingsPageObject {

    private val seekBar = element("com.rimidalv.dictaphone:id/seekBar")
    private val playRecordButton = element("com.rimidalv.dictaphone:id/row_img_play")
    private val fileNameTitle = element("com.rimidalv.dictaphone:id/row_file_name")

    fun checkFileNameTitle(fileName: String) {
        fileNameTitle.should(Condition.have(Condition.text(fileName)))
    }
}
