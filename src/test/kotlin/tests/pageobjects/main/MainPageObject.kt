package tests.pageobjects.main

import com.codeborne.selenide.SelenideElement
import helpers.ApplicationContainer
import helpers.elementById
import helpers.elementsById
import org.openqa.selenium.By
import tests.pageobjects.BasePageObject

class MainPageObject(application: ApplicationContainer) : BasePageObject(application) {
    val recordingButton = elementById("com.rimidalv.dictaphone:id/recPauseBtn")
    private val recordingsList: List<SelenideElement> = elementsById("com.rimidalv.dictaphone:id/main_content")
    fun getRecordingByIndex(index: Int) = Recording(recordingsList[index])

    inner class Recording(private val recording: SelenideElement) : SelenideElement by recording {
        val name: SelenideElement
            get() = recording.find(By.id("com.rimidalv.dictaphone:id/row_file_name"))
        val duration: SelenideElement
            get() = recording.find(By.id("com.rimidalv.dictaphone:id/row_duration"))
    }
}
