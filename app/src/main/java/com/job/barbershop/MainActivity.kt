package com.job.barbershop

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.job.barbershop.util.TokenManager

class MainActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context): Intent =
            Intent(context, MainActivity::class.java)

        val tm: TokenManager by lazy {
            App.instance!!.tokenManager
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(ChooseLocationActivity.newIntent(this))
    }
}
