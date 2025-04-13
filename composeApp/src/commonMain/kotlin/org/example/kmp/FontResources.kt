package org.example.kmp

import org.jetbrains.compose.resources.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import kmp_faktura.composeapp.generated.resources.Res
import kmp_faktura.composeapp.generated.resources.*
import androidx.compose.runtime.Composable
import androidx.compose.material3.Typography

@Composable
fun SfProDisplayFontFamily() = FontFamily(
    Font(Res.font.sf_pro_display_ultralight, weight = FontWeight.ExtraLight, style = FontStyle.Normal),
    Font(Res.font.sf_pro_display_ultralight_italic, weight = FontWeight.ExtraLight, style = FontStyle.Italic),
    Font(Res.font.sf_pro_display_thin, weight = FontWeight.Thin, style = FontStyle.Normal),
    Font(Res.font.sf_pro_display_thin_italic, weight = FontWeight.Thin, style = FontStyle.Italic),
    Font(Res.font.sf_pro_display_light, weight = FontWeight.Light, style = FontStyle.Normal),
    Font(Res.font.sf_pro_display_light_italic, weight = FontWeight.Light, style = FontStyle.Italic),
    Font(Res.font.sf_pro_display_regular, weight = FontWeight.Normal, style = FontStyle.Normal),
    Font(Res.font.sf_pro_display_regular_italic, weight = FontWeight.Normal, style = FontStyle.Italic),
    Font(Res.font.sf_pro_display_medium, weight = FontWeight.Medium, style = FontStyle.Normal),
    Font(Res.font.sf_pro_display_medium_italic, weight = FontWeight.Medium, style = FontStyle.Italic),
    Font(Res.font.sf_pro_display_semi_bold, weight = FontWeight.SemiBold, style = FontStyle.Normal),
    Font(Res.font.sf_pro_display_semi_bold_italic, weight = FontWeight.SemiBold, style = FontStyle.Italic),
    Font(Res.font.sf_pro_display_bold, weight = FontWeight.Bold, style = FontStyle.Normal),
    Font(Res.font.sf_pro_display_bold_italic, weight = FontWeight.Bold, style = FontStyle.Italic),
    Font(Res.font.sf_pro_display_heavy, weight = FontWeight.ExtraBold, style = FontStyle.Normal),
    Font(Res.font.sf_pro_display_heavy_italic, weight = FontWeight.ExtraBold, style = FontStyle.Italic),
    Font(Res.font.sf_pro_display_black, weight = FontWeight.Black, style = FontStyle.Normal),
    Font(Res.font.sf_pro_display_black_italic, weight = FontWeight.Black, style = FontStyle.Italic),
)

@Composable
fun SfProTextFontFamily() = FontFamily(
    Font(Res.font.sf_pro_text_light, weight = FontWeight.Light, style = FontStyle.Normal),
    Font(Res.font.sf_pro_text_light_italic, weight = FontWeight.Light, style = FontStyle.Italic),
    Font(Res.font.sf_pro_text_regular, weight = FontWeight.Normal, style = FontStyle.Normal),
    Font(Res.font.sf_pro_text_regular_italic, weight = FontWeight.Normal, style = FontStyle.Italic),
    Font(Res.font.sf_pro_text_medium, weight = FontWeight.Medium, style = FontStyle.Normal),
    Font(Res.font.sf_pro_text_medium_italic, weight = FontWeight.Medium, style = FontStyle.Italic),
    Font(Res.font.sf_pro_text_semi_bold, weight = FontWeight.SemiBold, style = FontStyle.Normal),
    Font(Res.font.sf_pro_text_semi_bold_italic, weight = FontWeight.SemiBold, style = FontStyle.Italic),
    Font(Res.font.sf_pro_text_bold, weight = FontWeight.Bold, style = FontStyle.Normal),
    Font(Res.font.sf_pro_text_bold_italic, weight = FontWeight.Bold, style = FontStyle.Italic),
    Font(Res.font.sf_pro_text_heavy, weight = FontWeight.ExtraBold, style = FontStyle.Normal),
    Font(Res.font.sf_pro_text_heavy_italic, weight = FontWeight.ExtraBold, style = FontStyle.Italic),
)