package com.sparkrat.sparknetworking

import android.content.SharedPreferences

import java.util.UUID

class SessionInformation {

    private var _deviceId: String? = null
    var deviceId: String
        get() {
            if (_deviceId == null) {
                val settings = SparkNetworking.instance.context?.getSharedPreferences(PREFS_NAME, 0)
                _deviceId = settings?.getString("DeviceId", null)
            }
            if (_deviceId == null) {
                deviceId = UUID.randomUUID().toString()
            }
            return _deviceId!!
        }
        set(deviceId) {
            _deviceId = deviceId

            val settings = SparkNetworking.instance.context?.getSharedPreferences(PREFS_NAME, 0)
            val editor = settings?.edit()
            editor?.putString("DeviceId", _deviceId)
            editor?.commit()
        }

    companion object {
        val PREFS_NAME = "RPS-PREFS"
    }

}
