package helpers

import tests.pageobjects.BasePageObject
import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor


/**
 * A module that will contain different external modules and the application logic
 */

class ApplicationContainer {
    fun <T : BasePageObject> getPage(
        page: KClass<T>
    ): T {
        return page.primaryConstructor!!.call(this)
    }
}