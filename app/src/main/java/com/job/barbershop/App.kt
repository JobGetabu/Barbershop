package com.job.barbershop

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import com.job.barbershop.util.TokenManager

class App : Application() {

    val tokenManager: TokenManager
        get() {
            val preferences = getSharedPreferences(applicationContext.packageName, Context.MODE_PRIVATE)
            return TokenManager.getInstance(preferences)
        }

    override fun onCreate() {
        super.onCreate()

        // Setup singleton instance
        instance = this

    }

    companion object {
        // Singleton instance
        // Getter to access Singleton instance
        var instance: App? = null
            private set

        init {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        }
    }

}
