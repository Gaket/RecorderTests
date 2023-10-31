package actions

import com.codeborne.selenide.SelenideElement
import helpers.ApplicationContainer
import io.qameta.allure.Allure

class AssertAction(private val description: String, private val assertBlock: () -> SelenideElement) : Action {
    override fun go(application: ApplicationContainer) {
        Allure.step(description) { ->
            assertBlock()
        }
    }
}
