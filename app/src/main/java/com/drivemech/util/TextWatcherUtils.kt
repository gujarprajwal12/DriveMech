package com.drivemech.util



import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

object TextWatcherUtils {

    fun  TextWatcher(onTextChanged: (CharSequence?) -> Unit): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Not needed
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                onTextChanged.invoke(s)
            }

            override fun afterTextChanged(s: Editable?) {
                // Not needed
            }
        }
    }


}




