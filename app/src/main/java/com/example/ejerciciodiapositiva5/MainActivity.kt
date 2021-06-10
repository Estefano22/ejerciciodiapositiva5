package com.example.ejerciciodiapositiva5

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.example.ejerciciodiapositiva5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.isEnabled=false

        binding.editText1.addTextChangedListener(getTextWatcher())
        binding.editText2.addTextChangedListener(getTextWatcher())

        binding.button.setOnClickListener{
            binding.editText1.text.append(binding.editText2.text.toString())
            binding.editText2.text.clear()
        }

        binding.button.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) binding.textView.text = binding.button.tag.toString()
        }

        binding.editText1.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) binding.textView.text = binding.editText1.tag.toString()
        }

        binding.editText2.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) binding.textView.text = binding.editText2.tag.toString()
        }

    }

    private fun habilitarButton() {
        binding.button.isEnabled = binding.editText1.text.isNotEmpty() && binding.editText2.text.isNotEmpty()
    }

    private fun getTextWatcher() : TextWatcher {

        return object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                habilitarButton()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        }


    }


}