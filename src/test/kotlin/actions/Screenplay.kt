package actions

import helpers.ApplicationContainer

abstract class Screenplay : Action {
    abstract var steps: List<Action>

    override fun go(application: ApplicationContainer) {
        steps.forEach { step ->
            step.go(application)
        }
    }
}
