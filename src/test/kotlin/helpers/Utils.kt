package helpers

import java.util.*
import kotlin.time.Duration

fun generateRandomString(len: Int): String {
    return UUID.randomUUID().toString().substring(0, len)
}

fun generateRandomStringInSpecificRange(length: Int, charRange: SymbolsRange = SymbolsRange.CYRILLIC_LOWER_CASE): String {
    return (1..length)
        .map { charRange.range.random() }
        .joinToString("")
}

enum class SymbolsRange(val range: CharRange) {
    LATIN_LOWER_CASE('a'..'z'),
    LATIN_UPPER_CASE('A'..'Z'),
    CYRILLIC_LOWER_CASE('а'..'я'),
    CYRILLIC_UPPER_CASE('А'..'Я'),
    NUMBERS('0'..'9'),
    SPECIFIC_SYMBOLS('!'..'&')
}

fun convertTimeToInt(uiTime: String): Int {
    val regex = Regex("""^\d{2}:\d{2}:\d{2}$""")
    if (regex.matches(uiTime)) {
        val timeParts = uiTime.split(":").map {
            it.toInt()
        }
        return when (timeParts.size) {
            3 -> timeParts[0] * 3600 + timeParts[1] * 60 + timeParts[2]
            2 -> timeParts[0] * 60 + timeParts[1]
            else -> throw IllegalArgumentException("Invalid time format: $uiTime")
        }
    } else {
        throw IllegalArgumentException("Invalid time format: $uiTime")
    }
}

fun formatTime(hours: Int, minutes: Int, seconds: Int): String {
    return String.format("%02d:%02d:%02d", hours, minutes, seconds)
}

fun secondsToUiTime(seconds: Int): String {
    val hours = seconds / 3600
    val minutes = (seconds % 3600) / 60
    val secs = seconds % 60
    return String.format("%02d:%02d:%02d", hours, minutes, secs)
    // возможно придется скейлить, чтобы метод работал с kotlin.duration, тогда поменять сигнатуру timeToUiTime
}

fun convertKotlinSecondsToJava(time: Duration) = java.time.Duration.ofSeconds(time.inWholeSeconds)
