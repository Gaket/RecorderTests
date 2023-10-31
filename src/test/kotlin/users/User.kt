package users

import actions.Action
import helpers.ApplicationContainer

abstract class User(private val application: ApplicationContainer) {

    fun execute(vararg steps: Action) {
        steps.forEach { step ->
            step.go(application)
        }
    }
}
