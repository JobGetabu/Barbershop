package com.job.barbershop.payment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.job.barbershop.App
import com.job.barbershop.R
import com.job.barbershop.model.MyCard
import com.job.barbershop.util.TokenManager
import kotlinx.android.synthetic.main.fragment_payment.*

class FragmentPayment : Fragment() {

    val tm: TokenManager by lazy {
        App.instance!!.tokenManager
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_payment, container, false)
    }

    override fun onPause() {
        super.onPause()

        //presume user press next

        val cardno = cardNum.text.toString()
        val expiredate = expiredate.text.toString()
        val cvv = cvv.text.toString()

        val card = MyCard(number = cardno, expiry = expiredate,cvv = cvv)
        tm.card = card
    }

}