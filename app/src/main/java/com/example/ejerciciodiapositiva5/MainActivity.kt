package com.example.ejerciciodiapositiva5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.isEnabled = false


        EditText1.addTextChangedListener(getTextWatcher())
        editText2.addTextChangedListener(getTextWatcher())

        button.setOnClickListener{
            editText1.text.append(editText2.text.toString())
            editText2.text.clear()
        }

    }

    private fun enableButton() {
        button.isEnabled = editText1.text.isNotEmpty() && editText2.text.isNotEmpty()
    }

    private fun getTextWatcher() : TextWatcher {

        return object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                enableButton()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        }



    }
}