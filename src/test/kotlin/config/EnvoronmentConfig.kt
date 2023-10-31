package config

import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

object EnvironmentConfig {
    const val APP_PACKAGE = "com.rimidalv.dictaphone"
    const val APP_ACTIVITY = "com.rimidalv.dictaphone.feature.main.MainActivity"
    const val TEST_HOST = "http://127.0.0.1:4723"
    val TIME_TOLERANCE: Duration = 2.seconds
}
