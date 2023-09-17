package tests.pageobjects

import com.codeborne.selenide.appium.SelenideAppium.`$`
import com.codeborne.selenide.appium.SelenideAppiumElement
import io.appium.java_client.AppiumBy

class ListOfRecordingsPageObject {

    private val fileName = `$`(AppiumBy.id("com.rimidalv.dictaphone:id/row_file_name"))

    fun getFileNameTile(): SelenideAppiumElement {
        return fileName
    }


}