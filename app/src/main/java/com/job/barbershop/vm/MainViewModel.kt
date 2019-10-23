package com.job.barbershop.vm

import androidx.lifecycle.ViewModel
import com.job.barbershop.model.CutService
import com.job.barbershop.model.MyCard
import com.job.barbershop.model.MyDetails
import com.job.barbershop.model.ServiceTimer

class MainViewModel: ViewModel() {
    var pickedLocation: String = ""
    var cutServices = listOf<CutService>()
    var selectedStuff: String = ""
    var selectedDate: String = ""
    var selectedTime: String = ""

    //checkout
    lateinit var myCard: MyCard
    lateinit var myDetails: MyDetails
    lateinit var serviceTimer: ServiceTimer




}