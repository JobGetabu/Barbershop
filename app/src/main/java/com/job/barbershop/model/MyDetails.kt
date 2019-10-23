package com.job.barbershop.model

class MyDetails(var name: String = "", var email: String = "", var phone: String = "",
                var address: String = "", var county: String = "", var street: String = "",
                var houseNo: String = "")

class MyCard(var type: String = "Visa", var number: String, expiry: String = "", var cvv: String = "")