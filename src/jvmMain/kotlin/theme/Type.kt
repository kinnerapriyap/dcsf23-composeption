package theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font

val droidconSFFontFamily = FontFamily(
    Font("font/JosefinSans-Regular.ttf", FontWeight.Normal),
    Font("font/JosefinSans-SemiBold.ttf", FontWeight.SemiBold),
    Font("font/JosefinSans-Bold.ttf", FontWeight.Bold),
    Font("font/JosefinSans-Medium.ttf", FontWeight.Medium),
    Font("font/JosefinSans-Light.ttf", FontWeight.Light),
    Font("font/JosefinSans-Thin.ttf", FontWeight.Thin),
)

internal val droidconSFTypography = Typography(defaultFontFamily = droidconSFFontFamily)