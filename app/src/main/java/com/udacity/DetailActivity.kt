package com.udacity

import android.app.NotificationManager
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var notificationManager: NotificationManager
    private lateinit var status: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)

        notificationManager =
            ContextCompat.getSystemService(
                this,
                NotificationManager::class.java
            ) as NotificationManager
        notificationManager.cancelAll()
        val extras = intent.extras
        if (extras != null) {

            status = extras.getString("EXTRA_DOWNLOAD_STATUS")!!
            file_name.text = extras.getString("EXTRA_FILENAME")!!
            status_text.text = status

            if (status == getString(R.string.successful))
                status_text.setTextColor(getColor(R.color.green))
            else
                status_text.setTextColor(getColor(R.color.red))
        } else {
            status_text.text = getString(R.string.no_found_text)
            file_name.text = getString(R.string.no_found_text)
        }
        ok_button.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }

    }

}