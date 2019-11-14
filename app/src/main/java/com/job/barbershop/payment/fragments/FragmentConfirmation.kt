package com.job.barbershop.payment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.job.barbershop.MainActivity.Companion.tm
import com.job.barbershop.R
import kotlinx.android.synthetic.main.fragment_confirmation.*

class FragmentConfirmation : Fragment() {

    private var edit_pay: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_confirmation, container, false)

        edit_pay = root.findViewById(R.id.edit_pay)

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        edit_pay!!.setOnClickListener {}

        cardno.text = tm.card?.number
        maname.text = tm.myDetails?.name
        address.text = tm.myDetails?.address

        sel1.text = tm.selectedStuff

    }
}