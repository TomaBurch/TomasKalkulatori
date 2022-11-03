package com.example.tomascalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

private lateinit var tvResult: TextView
private lateinit var tvClear: TextView
private var operand = 0.0
private var operation = ""


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvClear = findViewById(R.id.tvClear)
        tvResult = findViewById(R.id.tvResult)


    }

    fun numberClick(clickedView: View) {

        if (clickedView is TextView) {
            var text = tvResult.text.toString()
            val number = clickedView.text.toString()
            if (text == "0") {
                text = ""
            }
            val result = text + number
            tvResult.text = result

        }
    }


    fun operaciebi(clickedView: View) {
        if (clickedView is TextView) {

            operand = tvResult.text.toString().toDouble()
            operation = clickedView.text.toString()
            tvResult.text = ""

                }
        }

    fun toloba(clickedView: View) {
        val secondOperand = tvResult.text.toString().toDouble()
        when (operation) {
            "+" -> tvResult.text = (operand + secondOperand).toString()
            "-" -> tvResult.text = (operand - secondOperand).toString()
            "*" -> tvResult.text = (operand * secondOperand).toString()
            "/" -> tvResult.text = (operand / secondOperand).toString()
        }
    }

    fun Del(clickedView: View) {
        if (clickedView is TextView) {

            if (tvResult.text.toString() != "0") {
                tvResult.text = tvResult.text.toString().dropLast(1)
            }
        }
    }

    fun Clear(clickedView: View) {
        if (clickedView is TextView) {
            tvResult.text = "0"
        }
    }

    fun dot(clickedView: View) {
        if (clickedView is TextView) {
            tvResult.text = (tvResult.text.toString() + clickedView.text.toString())
            var a = 0
            for (b in tvResult.text) {
                if (b == '.') {
                    a++
                }
            }
                 if (a >= 2) {
                     tvResult.text = tvResult.text.dropLast(1)
            }
        }
    }
}


