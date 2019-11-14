package com.job.barbershop

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.firebase.firestore.FirebaseFirestore


class BookingDetailsActivity : BaseActivity() {

    val db = FirebaseFirestore.getInstance()

    companion object {
        fun newIntent(context: Context): Intent =
            Intent(context, BookingDetailsActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_details)

        val progress = ProgressDialog(this)
        progress.setTitle("Booking your service")
        progress.setMessage("Wait while loading...")
        progress.setCancelable(false) // disable dismiss by tapping outside of the dialog
        progress.show()


        val id = db.collection("User").document().id

        val user = hashMapOf(
            "userId" to id,
            "name" to tm.myDetails?.name,
            "email" to tm.myDetails?.email,
            "houseNo" to tm.myDetails?.houseNo,
            "street" to tm.myDetails?.street,
            "address" to tm.myDetails?.address,
            "phone" to tm.myDetails?.phone
        )

        val service1 = hashMapOf(
            "userId" to id,
            "name" to tm.myDetails?.name,
            "name" to tm.cutService1?.name,
            "price" to tm.cutService1?.price,
            "time" to tm.selectedTime,
            "date" to tm.selectedDate
        )

        val service2 = hashMapOf(
            "userId" to id,
            "userName" to tm.myDetails?.name,
            "name" to tm.cutService2?.name,
            "price" to tm.cutService2?.price,
            "time" to tm.selectedTime,
            "date" to tm.selectedDate
        )

        val pay = hashMapOf(
            "userId" to id,
            "name" to tm.myDetails?.name,
            "cardnumber" to tm.card?.number,
            "expiry" to tm.card?.expiry,
            "cvv" to tm.card?.cvv
        )


        db.runBatch {

            db.collection("User").document(id).set(user)
            db.collection("FirstCutService").document(id).set(service1)
            db.collection("SecondCutService").document(id).set(service2)
            db.collection("PaymentDetails").document(id).set(pay)

        }.addOnCompleteListener {
            progress.setTitle("Successfully updated the booking")
            progress.setMessage(" :) ")
            progress.setCancelable(true)

        }.addOnFailureListener {

            progress.setTitle("Error Occured")
            progress.setMessage("${it.localizedMessage}  \n ${it.message}  \n ${it.cause.toString()}")
            progress.setCancelable(true)
        }
    }

    fun toHome(v: View) {
        startActivity(ChooseLocationActivity.newIntent(this))
        finish()
    }
}
