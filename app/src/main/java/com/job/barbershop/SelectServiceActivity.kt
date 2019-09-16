package com.job.barbershop

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.job.barbershop.payment.ShoppingCheckoutStep
import com.job.barbershop.util.Tools
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog
import kotlinx.android.synthetic.main.activity_select_service.*
import java.util.*


class SelectServiceActivity : AppCompatActivity() {

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
    }

    fun showCalenderPicker(v: View){

        val cur_calender = Calendar.getInstance()
        val datePicker = DatePickerDialog.newInstance(
            { view, year, monthOfYear, dayOfMonth ->
                val calendar = Calendar.getInstance()
                calendar.set(Calendar.YEAR, year)
                calendar.set(Calendar.MONTH, monthOfYear)
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                val date_ship_millis = calendar.timeInMillis


                date.editText!!.setText(Tools.getFormattedDateSimple(date_ship_millis))
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


    fun showDatePicker(v: View){
        val cur_calender = Calendar.getInstance()
        val datePicker = TimePickerDialog.newInstance({ _, hourOfDay, minute, second ->

            time.editText!!.setText("$hourOfDay : $minute")
        },

            cur_calender.get(Calendar.HOUR_OF_DAY), cur_calender.get(Calendar.MINUTE),
            false)
        //set dark light
        datePicker.isThemeDark = true
        datePicker.accentColor = resources.getColor(R.color.colorPrimary)
        datePicker.show(fragmentManager, "Timepickerdialog")
    }

    fun toCheckOut(){
        startActivity(Intent(this,ShoppingCheckoutStep::class.java))
    }
}
