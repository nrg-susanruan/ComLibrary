package com.example.comlibrary.ui.theme

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
data class BrandColors(
    val light: ThemeColors,
    val dark: ThemeColors
)

@Serializable
data class ThemeColors(
    val colors: ColorTokens
)

@Serializable
data class ColorTokens(
    val primaryBase: String,
    val secondaryBase: String,
    val tertiaryBase: String
)

data class AppColors(
    val primaryBase: Color,
    val secondaryBase: Color,
    val tertiaryBase: Color
)

val LocalAppColors = compositionLocalOf<AppColors> {
    error("No AppColors provided")
}

// Parses hex strings
fun String.toColor(): Color {
    val cleanHex = this.trim().removePrefix("#")
    return Color(android.graphics.Color.parseColor("#$cleanHex"))
}

// Token Loading
object ColorTokenProvider {
    private var cachedTokens: Map<String, BrandColors>? = null

    fun loadColorTokens(context: Context, fileName: String = "colors.json"): Map<String, BrandColors> {
        if (cachedTokens != null) return cachedTokens!!
        return try {
            val jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
            cachedTokens = Json.decodeFromString(jsonString)
            cachedTokens!!
        } catch (e: Exception) {
            emptyMap()
        }
    }
}

// Transforms ColorTokens into AppColors
fun ColorTokens.toAppColors(): AppColors {
    return AppColors(
        primaryBase = primaryBase.toColor(),
        secondaryBase = secondaryBase.toColor(),
        tertiaryBase = tertiaryBase.toColor()
    )
}





//package com.example.comlibrary.ui.theme
//
//import android.content.Context
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.compositionLocalOf
//import androidx.compose.runtime.CompositionLocalProvider
//import androidx.compose.ui.graphics.Color
//import kotlinx.serialization.Serializable
//import kotlinx.serialization.decodeFromString
//import kotlinx.serialization.json.Json
//import java.io.IOException
//
//// Data classes to match the JSON structure
//@Serializable
//data class BrandColors(
//    val light: ThemeColors,
//    val dark: ThemeColors
//)
//
//@Serializable
//data class ThemeColors(
//    val colors: ColorTokens
//)
//
//@Serializable
//data class ColorTokens(
//    val primaryBase: String,
//    val secondaryBase: String,
//    val tertiaryBase: String
//)
//
//// Compose color palette
//data class AppColors(
//    val primaryBase: Color,
//    val secondaryBase: Color,
//    val tertiaryBase: Color
//)
//
//// CompositionLocal to provide colors
//val LocalAppColors = compositionLocalOf<AppColors> {
//    error("No AppColors provided")
//}
//
//// Helper function to parse hex color
//fun String.toColor(): Color {
//    val cleanHex = this.trim().removePrefix("#")
//    return Color(android.graphics.Color.parseColor("#$cleanHex"))
//}
//
//// Load and parse JSON from assets (non-composable)
//fun loadColorTokens(context: Context?, fileName: String = "colors.json"): Map<String, BrandColors> {
//    return context?.let {
//        try {
//            val jsonString = it.assets.open(fileName).bufferedReader().use { it.readText() }
//            Json.decodeFromString<Map<String, BrandColors>>(jsonString)
//        } catch (e: IOException) {
//            emptyMap()
//        }
//    } ?: emptyMap() // Return empty map if context is null
//}
//
//// Convert ColorTokens to AppColors
//fun ColorTokens.toAppColors(): AppColors {
//    return AppColors(
//        primaryBase = primaryBase.toColor(),
//        secondaryBase = secondaryBase.toColor(),
//        tertiaryBase = tertiaryBase.toColor()
//    )
//}
//
// //Composable to provide colors based on brand and theme
//@Composable
//fun AppTheme(
//    context: Context?,
//    brand: String = "brandDE",
//    isDarkTheme: Boolean = false,
//    content: @Composable () -> Unit
//) {
//    // Load tokens outside of composition to avoid recomposition issues
//    val colorTokens = loadColorTokens(context)
//    val brandColors = colorTokens[brand] ?: colorTokens["brandDE"]!!
//    val themeColors = if (isDarkTheme) brandColors.dark else brandColors.light
//    val appColors = themeColors.colors.toAppColors()
//
//    CompositionLocalProvider(LocalAppColors provides appColors) {
//        content()
//    }
//}
//
//
//
//// Example usage in a Composable
//@Composable
//fun ExampleScreen() {
//    val colors = LocalAppColors.current
//    // Use colors.primaryBase, colors.secondaryBase, etc. in your UI
//}