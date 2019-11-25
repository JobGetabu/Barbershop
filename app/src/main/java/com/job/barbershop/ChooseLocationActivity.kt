package com.job.barbershop

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.firebase.firestore.FirebaseFirestore

class ChooseLocationActivity : BaseActivity() {

    lateinit var ctx: ChooseLocationActivity

    companion object {
        fun newIntent(context: Context): Intent =
            Intent(context, ChooseLocationActivity::class.java)

        val db = FirebaseFirestore.getInstance()
        val id = db.collection("User").document().id
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_location)


        tm.id = id
        ctx = this
    }

    fun toCut(v: View) {
        tm.pickedLocation = "Dedan Kimathi, Nyeri"
        startActivity(CutsActivity.newIntent(this))

        val loc = hashMapOf(
            "userId" to id,
            "location" to "Dedan Kimathi, Nyeri"
        )
        db.collection("UserLocation").document(id).set(loc)
    }

    fun toCut2(v: View) {
        tm.pickedLocation = "Kamakwa, Nyeri"
        startActivity(CutsActivity.newIntent(this))

        val loc = hashMapOf(
            "userId" to id,
            "location" to "Kamakwa, Nyeri"
        )
        db.collection("UserLocation").document(id).set(loc)
    }

    fun toCut3(v: View) {
        tm.pickedLocation = "Nyeri Town, Nyeri"
        startActivity(CutsActivity.newIntent(this))

        val loc = hashMapOf(
            "userId" to id,
            "location" to "Nyeri Town, Nyeri"
        )
        db.collection("UserLocation").document(id).set(loc)
    }
}
