package com.job.barbershop.payment.fragments

import android.app.Activity
import android.app.ProgressDialog
import android.app.ProgressDialog.STYLE_HORIZONTAL
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.braintreepayments.api.dropin.DropInActivity
import com.braintreepayments.api.dropin.DropInRequest
import com.braintreepayments.api.dropin.DropInResult
import com.job.barbershop.App
import com.job.barbershop.R
import com.job.barbershop.model.MyCard
import com.job.barbershop.util.TokenManager
import com.loopj.android.http.AsyncHttpClient
import kotlinx.android.synthetic.main.fragment_payment.*
import kotlin.random.Random


class FragmentPayment : Fragment() {

    lateinit var client: AsyncHttpClient
    var progressBar: ProgressDialog? = null
    var userId = 0

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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        paypal.setOnClickListener {
            getClientToken()
        }

        make_pay.setOnClickListener {

            val progress = ProgressDialog(context!!)
            progress.setTitle("Processing payment")
            progress.setMessage("Please wait...")
            progress.setCancelable(false) // disable dismiss by tapping outside of the dialog
            progress.show()

            Handler().postDelayed({

                progress.setTitle("Successful")
                progress.setMessage("Card payment done...")
                progress.setCancelable(true)
                progress.setProgressStyle(STYLE_HORIZONTAL)

                Handler().postDelayed({

                    progress?.dismiss()

                }, 2000)

            }, 4000)

        }

        val id = Random(4).nextInt()

        progressBar = ProgressDialog(context)

        userId = id


        save.setOnClickListener {

            //presume user press next

            val cardno = cardNum.text.toString()
            val expiredate = expiredate.text.toString()
            val cvv = cvv.text.toString()

            val card = MyCard(number = cardno, expiry = expiredate, cvv = cvv)
            tm.card = card

            Toast.makeText(context,"Card Saved" , Toast.LENGTH_LONG).show()
        }

    }


    override fun onPause() {
        super.onPause()

    }


    private fun getClientToken() {
        progressBar?.show()
        progressBar?.setCancelable(false)

        try {


            try { // whenewer you get token from the server, pass it below in DropInRequest
                val dropInRequest =
                    DropInRequest().clientToken("XXXXXXXX_${Random(6L).nextFloat()}")
                dropInRequest.amount("1000")
                getActivity()!!.startActivityForResult(dropInRequest.getIntent(getActivity()!!), 512)
                progressBar!!.dismiss()
            } catch (e: Exception) {
                e.printStackTrace()
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == 512) {
            if (resultCode == Activity.RESULT_OK) {
                val result: DropInResult =
                    data?.getParcelableExtra(DropInResult.EXTRA_DROP_IN_RESULT)!!
                // here you will get nonce for the payment
                val nNonce = result.paymentMethodNonce!!.nonce
                // you also can check payment type is from paypal or Card
                val payment_type = result.paymentMethodType!!.canonicalName
                if (nNonce != null && payment_type != null) {

                    Toast.makeText(context,"Payment done, Send this nonce to server" , Toast.LENGTH_LONG).show()


                    progressBar?.setTitle("$payment_type")
                    progressBar?.setMessage("Card payment $nNonce")
                    progressBar?.setCancelable(true)
                    progressBar?.setProgressStyle(STYLE_HORIZONTAL)

                }
            } else if (resultCode == Activity.RESULT_CANCELED) {
                print("Payment cancelled by user, go back to previous activity")
                Toast.makeText(context,"Payment cancelled by user, go back to previous activity" , Toast.LENGTH_LONG).show()
                progressBar?.dismiss()

            } else { // handle errors here, an exception may be available in
                val error =
                    data?.getSerializableExtra(DropInActivity.EXTRA_ERROR) as java.lang.Exception
                Log.d("",""+error)
                Toast.makeText(context,"Get some unknown error, go back to previous activity" , Toast.LENGTH_LONG).show()
                progressBar?.dismiss()
            }
        }
    }

}