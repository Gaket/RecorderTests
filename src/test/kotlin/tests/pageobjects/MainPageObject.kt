package tests.pageobjects

import com.codeborne.selenide.Condition.visible
import helpers.element

class MainPageObject {
    private val recordButton = element("com.rimidalv.dictaphone:id/recPauseBtn")
    private val title = element("com.rimidalv.dictaphone:id/textView2")

    fun clickRecordButton() {
        recordButton.click()
    }

    fun checkVisibilityOfTitle() {
        title.shouldBe(visible)
    }
}
