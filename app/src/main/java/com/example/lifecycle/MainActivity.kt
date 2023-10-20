package com.example.lifecycle

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCheck : Button = findViewById(R.id.btnCheck)
        btnCheck.setOnClickListener {
            checkDate()
        }

        val btnRegister : Button = findViewById(R.id.btnRegister)
        btnRegister.setOnClickListener {
            register()
        }
    }

    private fun checkDate(): Boolean {
        val date : EditText = findViewById(R.id.etBirthday)
        println(date.text.toString())

        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        dateFormat.isLenient = false
        return try {
            dateFormat.parse(date.text.toString())
            val toast = Toast.makeText(this, "Valid!", Toast.LENGTH_SHORT)
            toast.show()
            true
        } catch (e: Exception) {
            val toast = Toast.makeText(this, "Invalid!", Toast.LENGTH_SHORT)
            toast.show()
            false
        }
    }

    private fun register() {
        val firstName : EditText = findViewById(R.id.etFirstname)
        val lastName : EditText = findViewById(R.id.etLastname)
        val address : EditText = findViewById(R.id.etAddress)
        val email : EditText = findViewById(R.id.etEmail)
        val rdBtnMale : RadioButton = findViewById(R.id.rbMale)
        val rdBtnFemale : RadioButton = findViewById(R.id.rbFemale)
        val term : CheckBox = findViewById(R.id.termAgree)

        if (firstName.text.isEmpty() || lastName.text.isEmpty() || address.text.isEmpty() || email.text.isEmpty() || (!rdBtnMale.isChecked && !rdBtnFemale.isChecked) || !term.isChecked ) {
            if(firstName.text.isEmpty()) {
                val toast = Toast.makeText(this, "First name Require !", Toast.LENGTH_SHORT)
                toast.show()
            }
            if(lastName.text.isEmpty()) {
                val toast = Toast.makeText(this, "Last name Require !", Toast.LENGTH_SHORT)
                toast.show()
            }
            if(address.text.isEmpty()) {
                val toast = Toast.makeText(this, "Address Require !", Toast.LENGTH_SHORT)
                toast.show()
            }
            if(email.text.isEmpty()) {
                val toast = Toast.makeText(this, "Email Require !", Toast.LENGTH_SHORT)
                toast.show()
            }
            if(!rdBtnMale.isChecked && !rdBtnFemale.isChecked) {
                val toast = Toast.makeText(this, "Gender Require !", Toast.LENGTH_SHORT)
                toast.show()
            }
            if(!term.isChecked) {
                val toast = Toast.makeText(this, "Agree Terms of Use Require !", Toast.LENGTH_SHORT)
                toast.show()
            }
        } else {
            val toast = Toast.makeText(this, "Register Completed !", Toast.LENGTH_SHORT)
            toast.show()
            setContentView(R.layout.successful_scene)

            val tryAgain : Button = findViewById(R.id.btnTryAgain)
            tryAgain.setOnClickListener {
                tryAgain()
            }
        }
    }

    private fun tryAgain() {
        setContentView(R.layout.activity_main)
    }
}