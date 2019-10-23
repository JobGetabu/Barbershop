package com.job.barbershop

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.job.barbershop.util.Tools
import com.job.barbershop.util.ViewAnimation
import kotlinx.android.synthetic.main.activity_cuts.*

class CutsActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context): Intent =
            Intent(context, CutsActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cuts)

        ex1.setOnClickListener {
            toggleSection(ex1,l1)
        }

        ex2.setOnClickListener {
            toggleSection(ex2,l2)
        }

        ex3.setOnClickListener {
            toggleSection(ex3,l3)
        }
    }


    private fun toggleSection(toggleBtn: View, lyt_expand_input: View) {
        val show = toggleArrow(toggleBtn)
        if (show) {
            ViewAnimation.expand(lyt_expand_input
            )
            { Tools.nestedScrollTo(body, lyt_expand_input) }
        } else {
            ViewAnimation.collapse(lyt_expand_input)
        }
    }

    private fun toggleArrow(view: View): Boolean {
        return if (view.rotation == 0f) {
            view.animate().setDuration(200).rotation(180f)
            true
        } else {
            view.animate().setDuration(200).rotation(0f)
            false
        }
    }

    fun toSelectService(v:View){
        startActivity(Intent(this,SummaryActivity::class.java))
    }


    fun toLocation(v:View){
        startActivity(Intent(this,ChooseLocationActivity::class.java))
    }

}
