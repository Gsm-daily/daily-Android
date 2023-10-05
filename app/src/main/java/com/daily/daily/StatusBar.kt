package com.daily.daily

import android.graphics.Color
import android.view.Window
import androidx.core.view.WindowCompat

fun Window.setTransparentStatusBar() {
    statusBarColor = Color.TRANSPARENT
    WindowCompat.setDecorFitsSystemWindows(this, false)
    WindowCompat.getInsetsController(this, this.decorView).isAppearanceLightStatusBars = true
}
