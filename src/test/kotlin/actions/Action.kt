package actions

import helpers.ApplicationContainer

interface Action {
    fun go(application: ApplicationContainer)
}