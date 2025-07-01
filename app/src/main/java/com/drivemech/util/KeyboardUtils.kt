package com.drivemech.util

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

object KeyboardUtils {

    fun hideKeyboard(activity: Activity) {
        val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        // Find the currently focused view, so we can grab the correct window token from it.
        val view = activity.currentFocus ?: View(activity)

        // Hide the keyboard
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
