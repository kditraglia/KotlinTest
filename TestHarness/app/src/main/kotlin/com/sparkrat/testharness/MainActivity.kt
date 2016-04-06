package com.sparkrat.testharness

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import com.sparkrat.sparknetworking.SparkNetworking
import com.sparkrat.sparknetworking.requests.ConnectRequest

class MainActivity : AppCompatActivity() {

    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SparkNetworking.instance.initialize(this, url = "https://app.sharebase.com/ShareBaseAPI/")
        val button = findViewById(R.id.google_button)
        button!!.setOnClickListener {
            SparkNetworking.instance.execute(ConnectRequest("mobile@sharebase.com", "sharebase"))
        }
    }

}
