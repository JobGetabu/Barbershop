package com.job.barbershop

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View

class ChooseLocationActivity : BaseActivity() {

    lateinit var ctx: ChooseLocationActivity

    companion object {
        fun newIntent(context: Context): Intent =
            Intent(context, ChooseLocationActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_location)

        ctx = this
    }

    fun toCut(v: View){
        tm.pickedLocation = "Dedan Kimathi, Nyeri"
        startActivity(CutsActivity.newIntent(this))
    }

    fun toCut2(v: View){
        tm.pickedLocation = "Kamakwa, Nyeri"
        startActivity(CutsActivity.newIntent(this))
    }

    fun toCut3(v: View){
        tm.pickedLocation = "Nyeri Town, Nyeri"
        startActivity(CutsActivity.newIntent(this))
    }
}
