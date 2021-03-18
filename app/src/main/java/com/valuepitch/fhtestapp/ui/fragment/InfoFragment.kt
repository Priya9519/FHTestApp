package com.valuepitch.fhtestapp.ui.fragment

import android.app.DatePickerDialog
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment
import com.valuepitch.fhtestapp.R
import java.util.*


class InfoFragment  : Fragment() {

    private lateinit var swFixVar:SwitchCompat
    private lateinit var tvFixed:TextView
    private lateinit var tvVariable:TextView
    private lateinit var spinner:Spinner
    private lateinit var etAnsThree:EditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragment_info, container, false)
        initViews(root)
        return root
    }

    private fun initViews(root: View?) {
        swFixVar= root?.findViewById(R.id.swFixVar)!!
        tvFixed= root?.findViewById(R.id.tvFixed)!!
        tvVariable= root?.findViewById(R.id.tvVariable)!!
        spinner= root?.findViewById(R.id.spinner)!!
        etAnsThree= root?.findViewById(R.id.etAnsThree)!!


        val adapter = activity?.let {
            ArrayAdapter(
                it,
                android.R.layout.simple_spinner_item,
                resources.getStringArray(R.array.investment)
            )
        }
        spinner.adapter = adapter

        swFixVar.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                tvFixed.setTypeface(null,Typeface.NORMAL)
                tvVariable.setTypeface(null,Typeface.BOLD)
            }
            else{
                tvFixed.setTypeface(null,Typeface.BOLD)
                tvVariable.setTypeface(null,Typeface.NORMAL)
            }
        }

        etAnsThree?.setOnTouchListener(OnTouchListener { v, event ->
            val DRAWABLE_RIGHT = 2

            if (event.action == MotionEvent.ACTION_UP) {
                if (event.rawX >= etAnsThree.getRight() - etAnsThree.getCompoundDrawables()
                        .get(DRAWABLE_RIGHT).getBounds().width()
                ) {
                    showCalender()
                    return@OnTouchListener true
                }
            }
            false
        })

    }

    private fun showCalender(){
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)


        val dpd =
            activity?.let {
                DatePickerDialog(it, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

                    // Display Selected date in textbox
                    var newMonth:String=monthOfYear.toString()
                    var newDay: String=dayOfMonth.toString()
                    if(monthOfYear < 10){

                        newMonth = "0" + monthOfYear.plus(1);
                    } else{
                        newMonth= "" + monthOfYear.plus(1)
                    }
                    if(dayOfMonth < 10){

                        newDay  = "0" + dayOfMonth ;
                    }

                    etAnsThree?.setText(newDay+ "-" +newMonth+ "-" + year.toString())

                }, year, month, day)
            }
        dpd?.getDatePicker()?.setMinDate(System.currentTimeMillis() - 1000);
        dpd?.show()
    }
}