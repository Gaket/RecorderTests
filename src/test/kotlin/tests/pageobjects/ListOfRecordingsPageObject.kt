package tests.pageobjects

import com.codeborne.selenide.appium.SelenideAppium.`$`
import com.codeborne.selenide.appium.SelenideAppiumElement
import io.appium.java_client.AppiumBy

class ListOfRecordingsPageObject {

    private val seekBar = `$`(AppiumBy.id("com.rimidalv.dictaphone:id/seekBar"))
    private val playRecordButton = `$`(AppiumBy.id("com.rimidalv.dictaphone:id/row_img_play"))

    fun fileNameTitle() :SelenideAppiumElement{
        return `$`(AppiumBy.id("com.rimidalv.dictaphone:id/row_file_name"))
    }

    fun getSeekBar(): SelenideAppiumElement{
        return seekBar
    }


    fun clickPlayRecordButton(){
        playRecordButton.click()
    }


}