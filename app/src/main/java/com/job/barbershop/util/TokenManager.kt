package com.job.barbershop.util

import android.content.SharedPreferences


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
