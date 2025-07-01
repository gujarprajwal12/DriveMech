package com.drivemech.util

import android.widget.Button
import androidx.core.content.ContextCompat
import com.drivemech.R


object ButtonUtils {
    val ENABLED_COLOR = R.color.enabledButtonColor
    val DISABLED_COLOR = R.color.disabledButtonColor

    fun updateButtonState(button: Button, condition: Boolean) {
        button.isEnabled = condition
        val colorRes = if (condition) ENABLED_COLOR else DISABLED_COLOR
        button.setBackgroundColor(ContextCompat.getColor(button.context, colorRes))
    }
}
