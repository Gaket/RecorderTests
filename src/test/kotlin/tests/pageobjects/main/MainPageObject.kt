package tests.pageobjects.main

import com.codeborne.selenide.Condition.visible
import helpers.ApplicationContainer
import helpers.elementById
import tests.pageobjects.BasePageObject

class MainPageObject(application: ApplicationContainer) : BasePageObject(application) {
    val recordButton = elementById("com.rimidalv.dictaphone:id/recPauseBtn")
    val title = elementById("com.rimidalv.dictaphone:id/textView2")

    fun clickRecordButton() {
        recordButton.click()
    }

    fun checkVisibilityOfTitle() {
        title.shouldBe(visible)
    }
}
