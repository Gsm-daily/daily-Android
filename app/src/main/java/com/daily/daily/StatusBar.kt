package com.daily.daily

import android.graphics.Color
import android.os.Build
import android.view.Window
import androidx.annotation.RequiresApi
import androidx.core.view.WindowInsetsControllerCompat

@RequiresApi(Build.VERSION_CODES.R)
fun Window.setTransparentStatusBar() {
    this.apply {
        statusBarColor = Color.TRANSPARENT
        setDecorFitsSystemWindows(false)
        WindowInsetsControllerCompat(this, this.decorView).isAppearanceLightStatusBars = true
    }
}