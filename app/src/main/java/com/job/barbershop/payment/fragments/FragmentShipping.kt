package com.job.barbershop.payment.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.job.barbershop.App
import com.job.barbershop.R
import com.job.barbershop.model.MyDetails
import com.job.barbershop.util.TokenManager
import kotlinx.android.synthetic.main.fragment_shipping.*


class FragmentShipping : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_shipping, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val tm: TokenManager by lazy {
            App.instance!!.tokenManager
        }

        save.setOnClickListener {
            tm.myDetails.name = name.text.toString()
            tm.myDetails.email = email.text.toString()
            tm.myDetails.phone = phone.text.toString()
            tm.myDetails.address = street.text.toString() + " " + houseNo.text.toString()

            Toast.makeText(context, "Details Saved", Toast.LENGTH_LONG).show()

            val prefs = activity!!.getSharedPreferences(
                activity!!.applicationContext.packageName,
                Context.MODE_PRIVATE
            )
            val editor: SharedPreferences.Editor = prefs.edit()


            val myDetails = MyDetails(
                name.text.toString(),
                email.text.toString(),
                phone.text.toString(),
                address.text.toString(),
                county.text.toString(),
                houseNo.text.toString()
            )
            editor.putString("name", myDetails.name).apply()
            editor.putString("email", myDetails.email).apply()
            editor.putString("phone", myDetails.phone).apply()
            editor.putString("address", myDetails.address).apply()
            editor.putString("county", myDetails.county).apply()
            editor.putString("houseNo", myDetails.houseNo).apply()
            editor.commit()

        }

    }


}