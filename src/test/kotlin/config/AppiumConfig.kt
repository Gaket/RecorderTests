package config

import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL

class AppiumConfig {
    val driver: AndroidDriver
    init {
        val capabilities = DesiredCapabilities()
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android")
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554")
        capabilities.setCapability("autoAcceptAlerts", true)
        capabilities.setCapability("noReset", "true")
        capabilities.setCapability("appPackage", EnvironmentConfig.APP_PACKAGE)
        capabilities.setCapability("appActivity", EnvironmentConfig.APP_ACTIVITY)
        driver = AndroidDriver(URL("${EnvironmentConfig.TEST_HOST}/wd/hub"), capabilities)
    }
}
