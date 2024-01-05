package com.menkashah.foodorder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import com.menkashah.foodorder.databinding.ActivityChooseYourLocationBinding

class ChooseYourLocation : AppCompatActivity() {

private val binding: ActivityChooseYourLocationBinding by lazy {
    ActivityChooseYourLocationBinding.inflate(layoutInflater)
}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val LocationList = arrayOf("Bihar", "jaipur","gugoan", "haryana","Up","keral","tamilnadu","banglore",
                                    "jammu kashmir", "himachal","uttrakhand","MP","RAYPUT","Gujraat","Maharstra",
        "Haidrabad","Telgana","Udisa","Jharkhand","Kolkata","Manipur","nagalanid","sikkim","faridabad",
            "Rohtak");

        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,LocationList)
        val autoCompleteTextView = binding.autoComplete
        autoCompleteTextView.setAdapter(adapter)







    }
}