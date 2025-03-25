package com.example.kmp

import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.dp

object ActionsKmp {
    const val TOTAL_DOTS = 10
    const val CURRENT_INDEX = 0
    val unselectedColor = Color(0xFFEDF0F9)
    val selectedColor = Color(0xFF4C85FF)
    val onClick = {}
    val foreColor = Color(0xff3D4047)
    const val ACTION_TEXT = "Action"
    val backgroundRollColor = Color(0xffF6F9FF)
    val actionTextColor = Color(0xff3D4047)
    val arrowColor = Color(0xffB0B8BF)
    const val SLIDER_TOTAL_DOTS = 4
    const val ROW_TEXT = "Action"
    val rowTextColor = Color(0xff555963)
    val rowIconColor = Color.White
    val rowCircleColor = Color(0xff3D4047)
    const val ROW_CIRCLE_VISIBILITY = 1f
    val socialRowIconColor = Color.White
    val socialRowCircleColor = Color(0xff4C85FF)

}

object PaddingKmp {
    val paddingWidth = 375.dp
    val paddingHeight = 2.dp
    val paddingBackgroundColor = Color(0xFF4C85FF)
    const val PADDING_VISIBILITY = 0.2f
}

/**
 * Default value for functions [DotBanner], [DotPersonalOffer], [ActionSlider]
 */
val DefaultTotalDots = compositionLocalOf { ActionsKmp.TOTAL_DOTS }
/**
 * Default value for function [DotBanner]
 */
val DefaultCurrentIndex = compositionLocalOf { ActionsKmp.CURRENT_INDEX }
/**
 * Default value for functions [DotBanner], [DotPersonalOffer], [ActionSlider]
 */
val DefaultUnselectedColor = compositionLocalOf { ActionsKmp.unselectedColor }
/**
 * Default value for functions [DotBanner], [DotPersonalOffer], [ActionSlider]
 */
val DefaultSelectedColor = compositionLocalOf { ActionsKmp.selectedColor }
/**
 * Default value for functions [DotPersonalOffer], [ActionDown], [ActionUp], [ActionRollUp], [ActionRow], [SocialRow]
 */
val DefaultOnClick = compositionLocalOf { ActionsKmp.onClick }
/**
 * Default value for functions [ActionDown], [ActionUp]
 */
val DefaultForeColor = compositionLocalOf { ActionsKmp.foreColor }
/**
 * Default value for functions [ActionDown], [ActionUp]
 */
val DefaultActionText = compositionLocalOf { ActionsKmp.ACTION_TEXT }
/**
 * Default value for function [ActionRollUp]
 */
val DefaultBackgroundRollColor = compositionLocalOf { ActionsKmp.backgroundRollColor }
/**
 * Default value for function [ActionRollUp]
 */
val DefaultActionTextColor = compositionLocalOf { ActionsKmp.actionTextColor }
/**
 * Default value for function [ActionRollUp]
 */
val DefaultArrowColor = compositionLocalOf { ActionsKmp.arrowColor }
/**
 * Default value for function [ActionSlider]
 */
val DefaultSliderTotalDots = compositionLocalOf { ActionsKmp.SLIDER_TOTAL_DOTS }
/**
 * Default value for function [ActionRow]
 */
val DefaultRowText = compositionLocalOf { ActionsKmp.ROW_TEXT }
/**
 * Default value for function [ActionRow]
 */
val DefaultRowTextColor = compositionLocalOf { ActionsKmp.rowTextColor }
/**
 * Default value for function [ActionRow]
 */
val DefaultRowIconColor = compositionLocalOf { ActionsKmp.rowIconColor }
/**
 * Default value for function [ActionRow]
 */
val DefaultRowCircleColor = compositionLocalOf { ActionsKmp.rowCircleColor }
/**
 * Default value for function [ActionRow]
 */
val DefaultRowCircleVisibility = compositionLocalOf { ActionsKmp.ROW_CIRCLE_VISIBILITY }
/**
 * Default value for function [SocialRow]
 */
val DefaultSocialRowIconColor = compositionLocalOf { ActionsKmp.socialRowIconColor }
/**
 * Default value for function [SocialRow]
 */
val DefaultSocialRowCircleColor = compositionLocalOf { ActionsKmp.socialRowCircleColor }
/**
 * Default value for function [Padding]
 */
val DefaultPaddingWidth = compositionLocalOf { PaddingKmp.paddingWidth }
/**
 * Default value for function [Padding]
 */
val DefaultPaddingHeight = compositionLocalOf { PaddingKmp.paddingHeight }
/**
 * Default value for function [Padding]
 */
val DefaultPaddingBackgroundColor = compositionLocalOf { PaddingKmp.paddingBackgroundColor }
/**
 * Default value for function [Padding]
 */
val DefaultPaddingVisibility = compositionLocalOf { PaddingKmp.PADDING_VISIBILITY }

