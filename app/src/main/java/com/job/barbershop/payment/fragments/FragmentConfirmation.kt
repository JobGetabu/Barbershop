package com.job.barbershop.payment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.job.barbershop.App
import com.job.barbershop.R
import com.job.barbershop.util.TokenManager
import kotlinx.android.synthetic.main.fragment_confirmation.*

class FragmentConfirmation : Fragment() {

    private var edit_pay: TextView? = null

    val tm: TokenManager by lazy {
        App.instance!!.tokenManager
    }

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

        edit_pay!!.setOnClickListener {
            Toast.makeText(context,"Edit only in Web Admin",Toast.LENGTH_LONG).show()
        }

        cardno.text = tm.card?.number
        maname.text = tm.myDetails.name
        address.text = "${tm.myDetails?.address} ${tm.myDetails?.county} ${tm.myDetails?.houseNo}"

        sel1.text = tm.cutService1?.name
        sel1price.text = "Ksh ${tm.cutService1?.price}"

        sel2.text = tm.cutService2?.name
        sel2price.text = "Ksh ${tm.cutService2?.price}"

        val tt = (tm.cutService1!!.price) + (tm.cutService2!!.price)
        subtotal.text = "Ksh ${tt}"
        val ttt = tt + 20
        total.text = "Ksh " + (ttt)


        screen.setOnClickListener {

            cardno.text = tm.card?.number
            maname.text = tm.myDetails.name
            address.text =
                "${tm.myDetails?.address} ${tm.myDetails?.county} ${tm.myDetails?.houseNo}"

            sel1.text = tm.cutService1?.name
            sel1price.text = "Ksh ${tm.cutService1?.price}"

            sel2.text = tm.cutService2?.name
            sel2price.text = "Ksh ${tm.cutService2?.price}"

            val tt = (tm.cutService1!!.price) + (tm.cutService2!!.price)
            subtotal.text = "Ksh ${tt}"
            val ttt = tt + 20
            total.text = "Ksh " + (ttt)
        }

    }
}