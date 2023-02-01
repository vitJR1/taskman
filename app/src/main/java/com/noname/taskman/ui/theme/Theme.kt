package com.noname.taskman.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.core.view.ViewCompat
import com.noname.taskman.R

private val DarkColorScheme = darkColorScheme(
    primary = Gray50,
    primaryContainer = Yellow80,
    secondaryContainer = Yellow50,
    background = Black70,
    surface = Black30,
    surfaceTint = Black30,
    tertiaryContainer = Black70
)

private val LightColorScheme = lightColorScheme(
    primary = Black30,
    primaryContainer = Yellow80,
    secondaryContainer = Yellow50,
    background = White60,
    surface = White90,
    surfaceTint = Black30,
    tertiaryContainer = White60,
    
//    onPrimary  =  Black30,
//    onPrimaryContainer  =  Black30,
//    inversePrimary  =  Black30,
//    secondary  =  Black30,
//    onSecondary  =  Black30,
//    onSecondaryContainer  =  Black30,
//    tertiary  =  Black30,
//    onTertiary  =  Black30,
//    onTertiaryContainer  =  Black30,
//    onBackground  =  Black30,
//    onSurface  =  Black30,
//    surfaceVariant  =  Black30,
//    onSurfaceVariant  =  Black30,
//    inverseSurface  =  Black30,
//    inverseOnSurface  =  Black30,
//    error  =  Black30,
//    onError  =  Black30,
//    errorContainer  =  Black30,
//    onErrorContainer  =  Black30,
//    outline  =  Black30,
//    outlineVariant  =  Black30,
//    scrim  =  Black30

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun TaskmanTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = Black70.toArgb()
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}