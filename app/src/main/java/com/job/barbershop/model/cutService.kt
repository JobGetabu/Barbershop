package com.job.barbershop.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CutService(var name: String= "",var price: Number, var time: String) : Parcelable {
    override fun toString(): String {
        return "CutService(name='$name', price=$price, time='$time')"
    }



}

@Parcelize
data class ServiceTimer(var name: String = "", var time: Number) : Parcelable