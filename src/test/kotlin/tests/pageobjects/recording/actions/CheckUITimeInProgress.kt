package tests.pageobjects.recording.actions

import actions.Action
import helpers.ApplicationContainer
import helpers.allureStep
import tests.pageobjects.recording.RecordingPageObject
import kotlin.time.Duration

class CheckUITimeInProgress(val duration: Duration) : Action {
    override fun go(application: ApplicationContainer) {
        allureStep("Проверяем значение таймера после ожидания в течение $duration") {
            application.getPage(RecordingPageObject::class).checkUiTimeInProgress(duration)
        }
    }
}
