package com.drivemech.Ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.drivemech.R
import com.drivemech.databinding.ActivityVerifyScrrenBinding
import com.drivemech.util.ButtonUtils
import com.drivemech.util.SnackbarUtils
import com.drivemech.util.TextWatcherUtils
import com.google.android.material.snackbar.Snackbar

class VerifyScrren : AppCompatActivity() {

    private lateinit var binding: ActivityVerifyScrrenBinding
    var phonenumber = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityVerifyScrrenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initview()
        getsting()
        onclick()
    }

    private fun initview() {
        val textWatcher = TextWatcherUtils.TextWatcher { s ->
            updateLoginButtonState()
        }

        binding.pinview.addTextChangedListener(textWatcher)
    }

    private fun getsting() {
        try {

            binding.txtmoblenumber.text =   "OTP sent to  "+ intent.getStringExtra("key_phone_number")
            phonenumber = intent.getStringExtra("key_phone_number").toString()
        } catch (e :Exception ) {

       }

    }

    private fun onclick() {

        binding.btnResend.setOnClickListener {
            SnackbarUtils.showSuccessSnackbar(binding.root, "Resend OTP")
        }

        binding.btnVerifyOTP.setOnClickListener {
            isValidate()
            if (isValidate()) {
                SnackbarUtils.showSuccessSnackbar(binding.root, "Verify OTP")
            }
        }

        binding.btnChange.setOnClickListener {
            SnackbarUtils.showSuccessSnackbar(binding.root, "Change Number")
        }
    }


    private fun isValidate(): Boolean {

        if (binding.pinview.text.toString().isEmpty()){
            SnackbarUtils.showFailureSnackbar(binding.root, "Please Enter Otp ")
            return false
        }
        return true
    }



    private fun updateLoginButtonState() {
        val isNotEmpty = binding.pinview.text.toString().isNotEmpty()
        ButtonUtils.updateButtonState(binding.btnVerifyOTP, isNotEmpty)
    }


    companion object {
        const val TAG: String = "VerifyScreen"
        fun getIntent(context: Context, phoneNumber: String): Intent {
            val destIntent = Intent(context, VerifyScrren::class.java)
            destIntent.putExtra("key_phone_number", phoneNumber)
            return destIntent
        }
    }
}