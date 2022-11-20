package com.abrahamgudratli.registrationform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var details: Details

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupSpinner()
        setupRegisterButton()

    }

    private fun setupSpinner() {
        val genders = arrayOf("Male", "Female", "Other")
        val genderSpinnerAdapter = ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, genders)
        spinner_gender.adapter = genderSpinnerAdapter
    }

    private fun setupRegisterButton() {
        button_register.setOnClickListener {
            onClickRegisterButton()
        }
    }

    private fun onClickRegisterButton() {

        details = Details(
            edit_text_first_name.text.toString(),
            edit_text_last_name.text.toString(),
            edit_text_email.text.toString(),
            edit_text_phone.text.toString(),
            edit_text_password.text.toString(),
            spinner_gender.selectedItem.toString()
        )

        val intent = Intent(this, PreviewActivity::class.java)
        intent.putExtra("Details", details)
        startActivity(intent)

    }

}