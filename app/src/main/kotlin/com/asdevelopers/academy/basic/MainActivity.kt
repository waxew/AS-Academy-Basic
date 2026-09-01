package com.asdevelopers.academy.basic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

/**
 * تنها Activity برنامه Basic.
 * تمام Navigation و Screenهای عمومی توسط AS-Academy-Core مدیریت می‌شوند.
 */
class MainActivity : ComponentActivity() {
    /** Android این نقطه را هنگام ساخت Activity فراخوانی می‌کند. */
    override fun onCreate(savedInstanceState: Bundle?) {
        // چرخه حیات استاندارد Activity ابتدا به کلاس والد واگذار می‌شود.
        super.onCreate(savedInstanceState)

        // Bootstrap ابتدا محتوای محلی را فعال می‌کند و سپس Runtime Content Update را مستقل از APK بررسی می‌کند.
        setContent {
            BasicRuntimeContentApp()
        }
    }
}
