package tests

import config.AppiumConfig
import config.EnvironmentConfig
import io.appium.java_client.android.Activity
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach

abstract class BaseTest {
    private val appiumConfig = AppiumConfig()
    private val driver = appiumConfig.driver

    private fun grantPermissions() {
        val osName = System.getProperty("os.name").lowercase()
        val command = when {
            osName.contains("win") -> arrayOf("cmd.exe", "/c", "adb shell pm grant ${EnvironmentConfig.APP_PACKAGE} android.permission.RECORD_AUDIO")
            else -> arrayOf("bash", "-c", "adb shell pm grant ${EnvironmentConfig.APP_PACKAGE} android.permission.RECORD_AUDIO")
        }
        val process = Runtime.getRuntime().exec(command)
        val exitCode = process.waitFor()
        if (exitCode != 0) {
            /*TODO: какие проблемы можем здесь встретить?*/
        }
    }


    private fun startActivity() {
        /*TODO: избавиться от использования depricated method*/
        driver.startActivity(
            Activity(
                EnvironmentConfig.APP_PACKAGE,
                EnvironmentConfig.APP_ACTIVITY
            )
        )
    }

    private fun closeApp() {
        driver.terminateApp(EnvironmentConfig.APP_PACKAGE)
    }


    @BeforeEach
    fun setup() {
        closeApp()
        grantPermissions()
        startActivity()
    }

    @AfterEach
    fun teardown() {
        closeApp()
        driver.quit()
    }
}