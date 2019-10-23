package com.job.barbershop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.job.barbershop.util.TokenManager

abstract class BaseActivity : AppCompatActivity() {

    val TAG = "#theCut"


    val tm: TokenManager by lazy {
        App.instance!!.tokenManager
    }


    fun showSnack(meso: String){
        Snackbar.make(findViewById(android.R.id.content),meso,Snackbar.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
