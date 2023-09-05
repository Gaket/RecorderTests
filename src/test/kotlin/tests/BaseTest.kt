package tests

import com.codeborne.selenide.WebDriverRunner
import config.AppiumConfig
import config.EnvironmentConfig
import io.appium.java_client.android.Activity
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import java.io.IOException


abstract class BaseTest {
    private val appiumConfig = AppiumConfig()
    private val driver = appiumConfig.driver

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
        clearMetaData() // Нужно ли нам здесь добавлять какую-то логику для чистки?
        clearRecordings() // Нужно ли нам здесь добавлять какую-то логику для чистки?
    }

    private fun clearMetaData() {
        try {
            val clearJsonCommand = "adb shell rm -r \$EXTERNAL_STORAGE/Android/data/com.rimidalv.dictaphone/files/*"
            Runtime.getRuntime().exec(clearJsonCommand).waitFor()
        } catch (e: IOException) {
            println("Error executing the ADB command: ${e.message}")
        } catch (e: InterruptedException) {
            println("ADB command was interrupted: ${e.message}")
        }
    }

    private fun clearRecordings() {
        try {
            val clearRecordingsCommand = "adb shell rm -r \$EXTERNAL_STORAGE/Music/Recordings/Wear\\ Audio\\ Recorder/*"
            Runtime.getRuntime().exec(clearRecordingsCommand).waitFor()
        } catch (e: IOException) {
            println("Error executing the ADB command: ${e.message}")
        } catch (e: InterruptedException) {
            println("ADB command was interrupted: ${e.message}")
        }
    }
}