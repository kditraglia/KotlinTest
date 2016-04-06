package com.sparkrat.sparknetworking.requests

import android.util.Base64

class ConnectRequest(val username: String, val password: String) : Request() {
    override val requestName: String
        get() = "authenticate"
    override val requestType: String
        get() = "GET"
    override val authToken: String
        get() {
            val userCredentials = "$username:$password"
            val basicAuth = "Basic " + String(Base64.encode(userCredentials.toByteArray(), Base64.DEFAULT))
            return basicAuth
        }
}