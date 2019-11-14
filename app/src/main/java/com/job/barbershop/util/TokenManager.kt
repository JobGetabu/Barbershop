package com.job.barbershop.util

import android.content.SharedPreferences
import com.job.barbershop.model.MyCard
import com.job.barbershop.model.MyDetails


class TokenManager(private val prefs: SharedPreferences) {
    private val editor: SharedPreferences.Editor


    var pickedLocation: String?
        get() = prefs.getString("pickedLocation", null)
        set(pickedLocation) = editor.putString("pickedLocation", pickedLocation).apply()

    var selectedStuff: String?
        get() = prefs.getString("selectedStuff", null)
        set(selectedStuff) = editor.putString("selectedStuff", selectedStuff).apply()

    var selectedDate: String?
        get() = prefs.getString("selectedDate", null)
        set(selectedDate) = editor.putString("selectedDate", selectedDate).apply()

    var selectedTime: String?
        get() = prefs.getString("selectedTime", null)
        set(selectedTime) = editor.putString(selectedTime, selectedTime).apply()

    var card: MyCard?
    get() = MyCard(
        type = "Visa",
        number = prefs.getString("number", "424242424242424")!!,
        expiry =  prefs.getString("expiry", "10/20")!!,
        cvv = prefs.getString("cvv", "123")!!

    )
    set(card) {
        editor.putString("number", card!!.number).apply()
        editor.putString("expiry", card!!.expiry).apply()
        editor.putString("cvv", card!!.cvv).apply()
    }

    var myDetails: MyDetails?
    get() = MyDetails(
        name = prefs.getString("name", "Lawrence Maluki")!!,
        email = prefs.getString("email", "lawmaluki@gmail.com")!!,
        phone = prefs.getString("phone", "2547081234")!!,
        address = prefs.getString("address", "Tamaal side block 2")!!,
        county = prefs.getString("county", "Nyeri")!!,
        houseNo = prefs.getString("houseNo", "567898")!!
    )
    set(myDetails) {
        editor.putString("number", myDetails!!.name).apply()
        editor.putString("email", myDetails!!.email).apply()
        editor.putString("phone", myDetails!!.phone).apply()
        editor.putString("address", myDetails!!.address).apply()
        editor.putString("county", myDetails!!.county).apply()
        editor.putString("houseNo", myDetails!!.houseNo).apply()
    }

    init {
        this.editor = prefs.edit()
    }

    fun DELETEALLPREFS() {
        editor.clear().apply()
    }

    companion object {
        private var INSTANCE: TokenManager? = null

        @Synchronized
        fun getInstance(prefs: SharedPreferences): TokenManager {
            if (INSTANCE == null) {
                INSTANCE = TokenManager(prefs)
            }

            return INSTANCE as TokenManager
        }
    }
}
