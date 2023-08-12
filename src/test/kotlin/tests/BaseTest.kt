package tests

import com.codeborne.selenide.WebDriverRunner
import config.AppiumConfig
import config.EnvironmentConfig
import io.appium.java_client.android.Activity
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach


abstract class BaseTest {
    private val appiumConfig = AppiumConfig()
    val driver = appiumConfig.driver

    private fun grantPermissions() {
        val osName = System.getProperty("os.name").lowercase()

        val permissions = listOf(
            "android.permission.RECORD_AUDIO",
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE"
        )

        for (permission in permissions) {
            val command = when {
                osName.contains("win") -> arrayOf("cmd.exe", "/c", "adb shell pm grant ${EnvironmentConfig.APP_PACKAGE} $permission")
                else -> arrayOf("bash", "-c", "adb shell pm grant ${EnvironmentConfig.APP_PACKAGE} $permission")
            }
            val process = Runtime.getRuntime().exec(command)
            val exitCode = process.waitFor()
            if (exitCode != 0) {
                throw RuntimeException("Failed to grant permission: $permission with exit code: $exitCode")
            }
        }

        /*TODO: разобраться с исчерпывающим списком разрешений + выработать политику тестирования*/
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
        WebDriverRunner.setWebDriver(driver)
    }

    @AfterEach
    fun teardown() {
        closeApp()
        driver.quit()
    }
}