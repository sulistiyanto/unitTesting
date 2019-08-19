package com.kodingmu.myunittesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.EditText
import android.text.TextUtils

class MainActivity : AppCompatActivity(), View.OnClickListener {
    val EXTRA_AGE = "extra_age"
    val EXTRA_NAME = "extra_name"
    private var mainViewModel: MainViewModel? = null
    private var edtWidth: EditText? = null
    private var edtHeight: EditText? = null
    private var edtLength: EditText? = null
    private var tvResult: TextView? = null
    private var btnCalculateVolume: Button? = null
    private var btnCalculateSurfaceArea: Button? = null
    private var btnCalculateCircumference: Button? = null
    private var btnSave: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = MainViewModel(CuboidModel())

        edtWidth = findViewById(R.id.edt_width)
        edtHeight = findViewById(R.id.edt_height)
        edtLength = findViewById(R.id.edt_length)
        tvResult = findViewById(R.id.tv_result)
        btnCalculateVolume = findViewById(R.id.btn_calculate_volume)
        btnCalculateCircumference = findViewById(R.id.btn_calculate_circumference)
        btnCalculateSurfaceArea = findViewById(R.id.btn_calculate_surface_area)
        btnSave = findViewById(R.id.btn_save)

        btnSave?.setOnClickListener(this)
        btnCalculateSurfaceArea?.setOnClickListener(this)
        btnCalculateCircumference?.setOnClickListener(this)
        btnCalculateVolume?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val length = edtLength?.text.toString().trim()
        val width = edtWidth?.text.toString().trim()
        val height = edtHeight?.text.toString().trim()
        if (TextUtils.isEmpty(length)) {
            edtLength?.error = "Field ini tidak boleh kosong"
        } else if (TextUtils.isEmpty(width)) {
            edtWidth?.error = "Field ini tidak boleh kosong"
        } else if (TextUtils.isEmpty(height)) {
            edtHeight?.error = "Field ini tidak boleh kosong"
        } else {
            val l = java.lang.Double.parseDouble(length)
            val w = java.lang.Double.parseDouble(width)
            val h = java.lang.Double.parseDouble(height)
            when {
                v?.id === R.id.btn_save -> {
                    mainViewModel?.save(l, w, h)
                    visible()
                }
                v?.id === R.id.btn_calculate_circumference -> {
                    tvResult?.text = "${mainViewModel?.getCircumference()}"
                    gone()
                }
                v?.id === R.id.btn_calculate_surface_area -> {
                    tvResult?.text = "${mainViewModel?.getSurfaceArea()}"
                    gone()
                }
                v?.id === R.id.btn_calculate_volume -> {
                    tvResult?.text = "${mainViewModel?.getVolume()}"
                    gone()
                }
            }
        }
    }

    fun visible() {
        btnCalculateVolume?.visibility = View.VISIBLE
        btnCalculateCircumference?.visibility = View.VISIBLE
        btnCalculateSurfaceArea?.visibility = View.VISIBLE
        btnSave?.visibility = View.GONE
    }

    fun gone() {
        btnCalculateVolume?.visibility = View.GONE
        btnCalculateCircumference?.visibility = View.GONE
        btnCalculateSurfaceArea?.visibility = View.GONE
        btnSave?.visibility = View.VISIBLE
    }
}
