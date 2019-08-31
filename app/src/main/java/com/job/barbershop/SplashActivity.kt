package com.job.barbershop

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.job.barbershop.util.Constants.PREF_FIRST_RUN


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        proceed()
    }

    private fun proceed() {
        val settings = getSharedPreferences(applicationContext.packageName, Context.MODE_PRIVATE)
        val firstRun = settings.getBoolean(PREF_FIRST_RUN, false)

        //if running for first time
        //Intro will load for first time
        if (!firstRun) {
            //done in Get Started Click
            val editor = settings.edit()
            editor.putBoolean(PREF_FIRST_RUN, true)
            editor.apply()
            //val i = Intent(this@SplashActivity, OnboardActivity::class.java) //introActivity
            //startActivity(i)
            //finish()

            //toast("TODO: add OnboardActivity activity")
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()

        } else {
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}