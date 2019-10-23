package com.job.barbershop

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.job.barbershop.model.CutService
import kotlinx.android.synthetic.main.activity_summary.*

class SummaryActivity : BaseActivity() {

    companion object {
        fun newIntent(context: Context): Intent =
            Intent(context, SummaryActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        val cutServices = intent.getParcelableArrayListExtra<CutService>("sss")

        cutServices.forEach {
            Log.d(TAG, "===>"+it.toString())
        }

        //set up UI
        tv1.text = cutServices[0].name
        tv2.text = cutServices[1].name

        price1.text = "Ksh ${cutServices[0].price}"
        price2.text = "Ksh ${cutServices[1].price}"

        val tt = cutServices[0].price + cutServices[1].price

        total.text = "Ksh ${tt}"

        textView7.text = tm.pickedLocation

    }

    fun close(v: View){
        onBackPressed()
        finish()
    }

    fun toCheckout(v:View){
        val intent = Intent(this,SelectServiceActivity::class.java)
        startActivity(intent)
    }

    fun toLocation(v: View) {
        startActivity(Intent(this, ChooseLocationActivity::class.java))
    }
}
