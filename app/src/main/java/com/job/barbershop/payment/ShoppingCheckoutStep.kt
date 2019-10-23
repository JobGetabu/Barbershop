package com.job.barbershop.payment

import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.job.barbershop.BookingDetailsActivity
import com.job.barbershop.R
import com.job.barbershop.payment.fragments.FragmentConfirmation
import com.job.barbershop.payment.fragments.FragmentPayment
import com.job.barbershop.payment.fragments.FragmentShipping
import com.job.barbershop.util.Tools


class ShoppingCheckoutStep : AppCompatActivity() {

    internal var array_state = arrayOf(State.SHIPPING, State.PAYMENT, State.CONFIRMATION)

    private var line_first: View? = null
    private var line_second: View? = null
    private var image_shipping: ImageView? = null
    private var image_payment: ImageView? = null
    private var image_confirm: ImageView? = null
    private var tv_shipping: TextView? = null
    private var tv_payment: TextView? = null
    private var tv_confirm: TextView? = null

    private var idx_state = 0

    enum class State {
        SHIPPING,
        PAYMENT,
        CONFIRMATION
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_checkout_step)
        initToolbar()
        initComponent()

        displayFragment(State.SHIPPING)
    }

    private fun initComponent() {
        line_first = findViewById(R.id.line_first) as View
        line_second = findViewById(R.id.line_second) as View
        image_shipping = findViewById<View>(R.id.image_shipping) as ImageView
        image_payment = findViewById<View>(R.id.image_payment) as ImageView
        image_confirm = findViewById<View>(R.id.image_confirm) as ImageView

        tv_shipping = findViewById<View>(R.id.tv_shipping) as TextView
        tv_payment = findViewById<View>(R.id.tv_payment) as TextView
        tv_confirm = findViewById<View>(R.id.tv_confirm) as TextView

        image_payment!!.setColorFilter(
            resources.getColor(R.color.grey_10),
            PorterDuff.Mode.SRC_ATOP
        )
        image_confirm!!.setColorFilter(
            resources.getColor(R.color.grey_10),
            PorterDuff.Mode.SRC_ATOP
        )

        findViewById<View>(R.id.lyt_next).setOnClickListener { v ->
            if (idx_state + 1 == array_state.size) {
                startActivity(Intent(this@ShoppingCheckoutStep, BookingDetailsActivity::class.java))
                finish()
                return@setOnClickListener
            }

            if (idx_state == array_state.size - 1) return@setOnClickListener
            idx_state++
            displayFragment(array_state[idx_state])


        }

        findViewById<View>(R.id.lyt_previous).setOnClickListener { v ->
            if (idx_state < 1) return@setOnClickListener
            idx_state--
            displayFragment(array_state[idx_state])
        }
    }

    private fun initToolbar() {
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar!!.title = null
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        Tools.setSystemBarColor(this, android.R.color.white)
        Tools.setSystemBarLight(this)
    }

    private fun displayFragment(state: State) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        var fragment: Fragment? = null
        refreshStepTitle()

        if (state.name.equals(State.SHIPPING.name, ignoreCase = true)) {
            fragment = FragmentShipping()
            tv_shipping!!.setTextColor(resources.getColor(R.color.grey_90))
            image_shipping!!.clearColorFilter()
        } else if (state.name.equals(State.PAYMENT.name, ignoreCase = true)) {
            fragment = FragmentPayment()
            line_first!!.setBackgroundColor(resources.getColor(R.color.colorPrimary))
            image_shipping!!.setColorFilter(
                resources.getColor(R.color.colorPrimary),
                PorterDuff.Mode.SRC_ATOP
            )
            image_payment!!.clearColorFilter()
            tv_payment!!.setTextColor(resources.getColor(R.color.grey_90))
        } else if (state.name.equals(State.CONFIRMATION.name, ignoreCase = true)) {
            fragment = FragmentConfirmation()
            line_second!!.setBackgroundColor(resources.getColor(R.color.colorPrimary))
            image_payment!!.setColorFilter(
                resources.getColor(R.color.colorPrimary),
                PorterDuff.Mode.SRC_ATOP
            )
            image_confirm!!.clearColorFilter()
            tv_confirm!!.setTextColor(resources.getColor(R.color.grey_90))
        }

        if (fragment == null) return
        fragmentTransaction.replace(R.id.frame_content, fragment)
        fragmentTransaction.commit()
    }

    private fun refreshStepTitle() {
        tv_shipping!!.setTextColor(resources.getColor(R.color.grey_20))
        tv_payment!!.setTextColor(resources.getColor(R.color.grey_20))
        tv_confirm!!.setTextColor(resources.getColor(R.color.grey_20))
    }
}

