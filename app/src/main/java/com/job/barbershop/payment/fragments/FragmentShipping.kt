package com.job.barbershop.payment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.job.barbershop.MainActivity.Companion.tm
import com.job.barbershop.R
import kotlinx.android.synthetic.main.fragment_shipping.*


class FragmentShipping : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_shipping, container, false)
    }

    override fun onPause() {
        super.onPause()

        tm.myDetails?.name = name.text.toString()
        tm.myDetails?.email = email.text.toString()
        tm.myDetails?.phone = phone.text.toString()
        tm.myDetails?.address = address.text.toString()
        tm.myDetails?.county = county.text.toString()
        tm.myDetails?.houseNo = street.text.toString() +" "+ houseNo.text.toString()
    }
}