package com.drivemech.util


import android.view.View
import androidx.core.content.ContextCompat
import com.drivemech.R
import com.google.android.material.snackbar.Snackbar

class SnackbarUtils {

    companion object {
        fun showSuccessSnackbar(view: View, message: String) {
            val snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG)
            val backgroundColor = ContextCompat.getColor(view.context, R.color.success_color)
            snackbar.setBackgroundTint(backgroundColor).show()
        }

        fun showFailureSnackbar(view: View, message: String) {
            val snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG)
            val backgroundColor = ContextCompat.getColor(view.context, R.color.failure_color)
            snackbar.setBackgroundTint(backgroundColor).show()
        }


        fun showLongSnackbarWithAction(
            view: View,
            message: String,
            actionText: String,
            action: () -> Unit
        ) {
            val snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG)
            snackbar.setAction(actionText) { action.invoke() }
            val backgroundColor = ContextCompat.getColor(view.context, R.color.failure_color)
            snackbar.setBackgroundTint(backgroundColor).show()
            snackbar.show()
        }

    }

}
