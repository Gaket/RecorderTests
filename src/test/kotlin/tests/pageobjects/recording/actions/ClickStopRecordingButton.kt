package tests.pageobjects.recording.actions

import actions.Action
import helpers.ApplicationContainer
import helpers.allureStep
import tests.pageobjects.recording.RecordingPageObject

class ClickStopRecordingButton : Action {
    override fun go(application: ApplicationContainer) {
        allureStep("Кликаем на кнопку остановки записи") {
            application.getPage(RecordingPageObject::class).stopRecordingButton.click()
        }
    }
}
