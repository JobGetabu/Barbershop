package com.job.barbershop

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View

class BookingDetailsActivity : BaseActivity() {

    companion object {
        fun newIntent(context: Context): Intent =
            Intent(context, BookingDetailsActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_details)
    }

    fun toHome(v: View){
        startActivity(ChooseLocationActivity.newIntent(this))
        finish()
    }
}
