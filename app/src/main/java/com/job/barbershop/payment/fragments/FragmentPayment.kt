package com.job.barbershop.payment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.job.barbershop.R
import kotlinx.android.synthetic.main.fragment_payment.*

class FragmentPayment : Fragment() {

    companion object{
    }
        val cardno = cardNum.text.toString()



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_payment, container, false)

        cardNum
    }
}