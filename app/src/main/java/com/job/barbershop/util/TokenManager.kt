package com.job.barbershop.util

import android.content.SharedPreferences
import com.job.barbershop.model.CutService
import com.job.barbershop.model.MyCard
import com.job.barbershop.model.MyDetails
import java.util.*


class TokenManager(private val prefs: SharedPreferences) {
    private val editor: SharedPreferences.Editor = prefs.edit()


    var id: String?
        get() = prefs.getString("id", null)
        set(id) = editor.putString("id", id).apply()

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
        set(selectedTime) = editor.putString("selectedTime", selectedTime).apply()

    var card: MyCard?
        get() = MyCard(
            type = "Visa",
            number = prefs.getString("number", "424242424242424")!!,
            expiry = prefs.getString("expiry", "10/20")!!,
            cvv = prefs.getString("cvv", "123")!!

        )
        set(card) {
            editor.putString("number", card!!.number).apply()
            editor.putString("expiry", card!!.expiry).apply()
            editor.putString("cvv", card!!.cvv).apply()
        }

    var myDetails: MyDetails
        get() = MyDetails(
            name = prefs.getString("name", "Lawrence Maluki")!!,
            email = prefs.getString("email", "lawmaluki@gmail.com")!!,
            phone = prefs.getString("phone", "2547081234")!!,
            address = prefs.getString("address", "Tamaal Room 8")!!,
            county = prefs.getString("county", "Nyeri")!!,
            houseNo = prefs.getString("houseNo", "567898")!!
        )
        set(myDetails) {
            editor.putString("name", myDetails!!.name).apply()
            editor.putString("email", myDetails!!.email).apply()
            editor.putString("phone", myDetails!!.phone).apply()
            editor.putString("address", myDetails!!.address).apply()
            editor.putString("county", myDetails!!.county).apply()
            editor.putString("houseNo", myDetails!!.houseNo).apply()
            editor.commit()
        }

    var cutService1: CutService?
        get() = CutService(
            name = prefs.getString("cutService1_name", "GentleMen's cut")!!,
            price = prefs.getInt("cutService1_price", 500),
            time = prefs.getString("cutService1_time", "${Date()}")!!
        )
        set(v) {
            editor.putString("cutService1_name", v!!.name).apply()
            editor.putInt("cutService1_price", v!!.price).apply()
            editor.putString("cutService1_time", v!!.time).apply()
        }

    var cutService2: CutService?
        get() = CutService(
            name = prefs.getString("cutService2_name", "GentleMen's cut")!!,
            price = prefs.getInt("cutService2_price", 500),
            time = prefs.getString("cutService2_time", "${Date()}")!!
        )
        set(v) {
            editor.putString("cutService2_name", v!!.name).apply()
            editor.putInt("cutService2_price", v!!.price).apply()
            editor.putString("cutService2_time", v!!.time).apply()
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
