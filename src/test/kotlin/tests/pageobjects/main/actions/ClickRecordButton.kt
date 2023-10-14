package tests.pageobjects.main.actions

import actions.Action
import helpers.ApplicationContainer
import helpers.allureStep
import tests.pageobjects.main.MainPageObject
import java.beans.PropertyChangeListener


class ClickRecordButton: Action {
    override fun go(application: ApplicationContainer) {
        allureStep("Кликаем на кнопку записи") {
            application.getPage(MainPageObject::class).recordButton.click()
        }
    }
}