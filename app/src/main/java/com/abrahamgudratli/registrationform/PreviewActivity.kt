package com.abrahamgudratli.registrationform

import android.annotation.SuppressLint
import android.app.Notification
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_preview.*

class PreviewActivity : AppCompatActivity() {
    lateinit var receivedDetails: Details
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)
        receiveDetails()
        displayDetails()
        clickableViews()
    }

    private fun clickableViews() {
        text_view_preview_details_email.setOnClickListener{
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto: ${receivedDetails.email}")
            startActivity(intent)
        }

        text_view_preview_details_phone.setOnClickListener{
            var intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel: ${receivedDetails.phone}")
            startActivity(intent)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun displayDetails() {

        text_view_preview_details_full_name.text = "Full Name:   ${receivedDetails.getFullName()}"
        text_view_preview_details_email.text = "Email:   ${receivedDetails.email}"
        text_view_preview_details_phone.text = "Phone:   ${receivedDetails.phone}"

    }

    private fun receiveDetails() {
        receivedDetails = intent.getSerializableExtra("Details") as Details
    }
}