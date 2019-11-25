package com.job.barbershop

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import com.job.barbershop.ChooseLocationActivity.Companion.db
import com.job.barbershop.payment.ShoppingCheckoutStep
import com.job.barbershop.util.Tools
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog
import kotlinx.android.synthetic.main.activity_select_service.*
import java.util.*


class SelectServiceActivity : BaseActivity() {

    companion object {
        fun newIntent(context: Context): Intent =
            Intent(context, SelectServiceActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_service)

        next.setOnClickListener {
            toCheckOut()
        }

        textView7.text = tm.pickedLocation

    }

    fun showCalenderPicker(v: View) {

        val cur_calender = Calendar.getInstance()
        val datePicker = DatePickerDialog.newInstance(
            { view, year, monthOfYear, dayOfMonth ->
                val calendar = Calendar.getInstance()
                calendar.set(Calendar.YEAR, year)
                calendar.set(Calendar.MONTH, monthOfYear)
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                val date_ship_millis = calendar.timeInMillis


                date.editText!!.setText(Tools.getFormattedDateSimple(date_ship_millis))

                tm.selectedDate = Tools.getFormattedDateSimple(date_ship_millis)
            },
            cur_calender.get(Calendar.YEAR),
            cur_calender.get(Calendar.MONTH),
            cur_calender.get(Calendar.DAY_OF_MONTH)
        )
        //set dark theme
        datePicker.isThemeDark = true
        datePicker.accentColor = resources.getColor(R.color.colorPrimary)
        datePicker.minDate = cur_calender
        datePicker.show(fragmentManager, "Datepickerdialog")

    }


    fun showDatePicker(v: View) {
        val cur_calender = Calendar.getInstance()
        val datePicker = TimePickerDialog.newInstance(
            { _, hourOfDay, minute, second ->

                time.editText!!.setText("$hourOfDay : $minute")

                tm.selectedTime = "$hourOfDay : $minute"
            },

            cur_calender.get(Calendar.HOUR_OF_DAY), cur_calender.get(Calendar.MINUTE),
            false
        )
        //set dark light
        datePicker.isThemeDark = true
        datePicker.accentColor = resources.getColor(R.color.colorPrimary)
        datePicker.show(fragmentManager, "Timepickerdialog")
    }

    fun toCheckOut() {

        val rd = findViewById<RadioButton>(radioGroup.checkedRadioButtonId).text.toString()
        tm.selectedStuff = rd

        if (tm.selectedDate == null || tm.selectedDate!!.isEmpty()) {
            showSnack("Select at least two services!")
            return
        }

        val service1 = hashMapOf(
            "userId" to ChooseLocationActivity.id,
            "name" to tm.myDetails?.name,
            "name" to tm.cutService1?.name,
            "price" to tm.cutService1?.price,
            "time" to tm.selectedTime,
            "selected" to tm.selectedStuff,
            "date" to tm.selectedDate
        )

        val service2 = hashMapOf(
            "userId" to ChooseLocationActivity.id,
            "userName" to tm.myDetails?.name,
            "name" to tm.cutService2?.name,
            "price" to tm.cutService2?.price,
            "time" to tm.selectedTime,
            "selected" to tm.selectedStuff,
            "date" to tm.selectedDate
        )

        db.collection("FirstCutService").document(ChooseLocationActivity.id).update(service1)
        db.collection("SecondCutService").document(ChooseLocationActivity.id).update(service2)

        startActivity(Intent(this, ShoppingCheckoutStep::class.java))
    }

    fun toLocation(v: View) {
        startActivity(Intent(this, ChooseLocationActivity::class.java))
    }
}
