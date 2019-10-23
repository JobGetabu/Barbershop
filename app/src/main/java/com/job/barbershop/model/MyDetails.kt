package com.job.barbershop.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class MyDetails(var name: String = "", var email: String = "", var phone: String = "",
                var address: String = "", var county: String = "", var street: String = "",
                var houseNo: String = "") : Parcelable

@Parcelize
class MyCard(var type: String = "Visa", var number: String, var expiry: String = "", var cvv: String = "") :
    Parcelable