package com.job.barbershop

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class SummaryActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context): Intent =
            Intent(context, SummaryActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)
    }

    fun close(v: View){
        onBackPressed()
        finish()
    }
}
