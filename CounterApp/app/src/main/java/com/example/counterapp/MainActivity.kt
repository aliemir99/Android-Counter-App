package com.example.counterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.counterapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var value  = 0
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.buttonCountUp.setOnClickListener { countUp() }

        binding.buttonCountDown.setOnClickListener { countDown() }

        binding.buttonToast.setOnClickListener{ makeToast(it) }
    }
    private fun countUp() {

        //Toast.makeText(this, value, Toast.LENGTH_SHORT).show()
        value +=1

        updateNumber()
    }
    private fun countDown() {

        //Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
        value -=1

        updateNumber()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("NUMBER",value)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val savedNumber = savedInstanceState.getInt("NUMBER")
        value = savedNumber;
        updateNumber()
    }
    private fun updateNumber(){
        binding.textNumber.text = value.toString()
    }
    private fun makeToast(view: View){
        Toast.makeText(applicationContext,"$value",Toast.LENGTH_SHORT).show()
    }
}