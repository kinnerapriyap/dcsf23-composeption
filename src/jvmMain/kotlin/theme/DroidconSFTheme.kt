package theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpSize

@Composable
fun DroidconSFTheme(
    windowSize: DpSize,
    darkMode: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val droidconSFColors = droidconSFColors(darkMode = darkMode)
    CompositionLocalProvider(
        LocalColors provides droidconSFColors,
        LocalWindowSize provides windowSize,
    ) {
        MaterialTheme(
            colors = droidconSFColors,
            typography = droidconSFTypography,
            content = content,
        )
    }
}

val LocalWindowSize = staticCompositionLocalOf { DpSize.Zero }

val LocalColors = staticCompositionLocalOf {
    lightColors(
        primary = Color(0xFF8BC34A),
        secondary = Color(0xFF607D8B),
        onPrimary = Color(0xFF212121),
        onSecondary = Color(0xFF757575)
    )
}