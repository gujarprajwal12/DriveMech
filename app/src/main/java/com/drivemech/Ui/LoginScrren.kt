package com.drivemech.Ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.drivemech.R
import com.drivemech.databinding.ActivityLoginScrrenBinding
import com.drivemech.util.ButtonUtils
import com.drivemech.util.KeyboardUtils
import com.drivemech.util.SnackbarUtils
import com.drivemech.util.TextWatcherUtils


class LoginScrren : AppCompatActivity() {

    private lateinit var binding: ActivityLoginScrrenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginScrrenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initView()
        onclick()
    }

    private fun initView() {
        val textWatcher = TextWatcherUtils.TextWatcher { s ->
            updateLoginButtonState()
        }

        binding.etMobileEmail.addTextChangedListener(textWatcher)

    }




    private fun onclick() {
        binding.btnVerifyOTP.setOnClickListener {
            val input = binding.etMobileEmail.text.toString()
            KeyboardUtils.hideKeyboard(this@LoginScrren)
            if (isValidate()) {
                val intent = VerifyScrren.getIntent(this@LoginScrren,input)
                startActivity(intent)
                Toast.makeText(this, "OTP sent to $input", Toast.LENGTH_SHORT).show()

            }
        }


        binding.btnMpin.setOnClickListener {
            Toast.makeText(this, "Navigate to MPIN login", Toast.LENGTH_SHORT).show()
        }

        binding.btnBiometric.setOnClickListener {
            Toast.makeText(this, "Trigger biometric auth", Toast.LENGTH_SHORT).show()
        }
    }

    private fun isValidate(): Boolean {

        if (binding.etMobileEmail.text.toString().isEmpty()){
            SnackbarUtils.showFailureSnackbar(binding.root, "Please Enter PhoneNumber or email id ")
            return false
        }
        return true
    }



    private fun updateLoginButtonState() {
        val isNotEmpty = binding.etMobileEmail.text.toString().isNotEmpty()
        ButtonUtils.updateButtonState(binding.btnVerifyOTP, isNotEmpty)
    }


}