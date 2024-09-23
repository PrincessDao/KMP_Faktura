package org.example.kmp

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight

actual fun getSfProDisplayFontFamily(): FontFamily {
    return FontFamily(
        Font(R.font.sf_pro_display_ultralight, FontWeight.W100, FontStyle.Normal),
        Font(R.font.sf_pro_display_ultralight_italic, FontWeight.W100, FontStyle.Italic),
        Font(R.font.sf_pro_display_thin, FontWeight.W200, FontStyle.Normal),
        Font(R.font.sf_pro_display_thin_italic, FontWeight.W200, FontStyle.Italic),
        Font(R.font.sf_pro_display_light, FontWeight.W300, FontStyle.Normal),
        Font(R.font.sf_pro_display_light_italic, FontWeight.W300, FontStyle.Italic),
        Font(R.font.sf_pro_display_regular, FontWeight.W400, FontStyle.Normal),
        Font(R.font.sf_pro_display_regular_italic, FontWeight.W400, FontStyle.Italic),
        Font(R.font.sf_pro_display_medium, FontWeight.W500, FontStyle.Normal),
        Font(R.font.sf_pro_display_medium_italic, FontWeight.W500, FontStyle.Italic),
        Font(R.font.sf_pro_display_semi_bold, FontWeight.W600, FontStyle.Normal),
        Font(R.font.sf_pro_display_semi_bold_italic, FontWeight.W600, FontStyle.Italic),
        Font(R.font.sf_pro_display_bold, FontWeight.W700, FontStyle.Normal),
        Font(R.font.sf_pro_display_bold_italic, FontWeight.W700, FontStyle.Italic),
        Font(R.font.sf_pro_display_heavy, FontWeight.W800, FontStyle.Normal),
        Font(R.font.sf_pro_display_heavy_italic, FontWeight.W800, FontStyle.Italic),
        Font(R.font.sf_pro_display_black, FontWeight.W900, FontStyle.Normal),
        Font(R.font.sf_pro_display_black_italic, FontWeight.W900, FontStyle.Italic),
    )
}