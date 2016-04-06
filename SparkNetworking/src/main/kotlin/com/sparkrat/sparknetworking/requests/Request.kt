package com.sparkrat.sparknetworking.requests

import com.sparkrat.sparknetworking.SparkNetworking

abstract class Request(requestMap: Map<String, String>?) {
    internal abstract val requestName : String
    internal abstract val requestType : String
    internal abstract val authToken : String

    protected val parameters: String
        get() = ""

    private val url: String
        get() {
            return SparkNetworking.instance.url + "/" + requestName
        }

    constructor() : this(null) {
    }
}
