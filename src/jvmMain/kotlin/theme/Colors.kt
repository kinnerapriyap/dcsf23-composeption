package theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

internal fun droidconSFColors(darkMode: Boolean) =
    if (darkMode) darkColors()
    else lightColors(
        primary = Color(0xFF8BC34A),
        secondary = Color(0xFF607D8B),
        onPrimary = Color(0xFF212121),
        onSecondary = Color(0xFF757575)
    )