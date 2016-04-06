package com.sparkrat.sparknetworking

import android.content.Context

import com.sparkrat.sparknetworking.requests.Request
import com.sparkrat.sparknetworking.responses.IResponseListener

class SparkNetworking {
    var context: Context? = null
        private set
    var url: String? = null
        private set
    var sessionInformation: SessionInformation? = null
        private set
    private var _serviceClient: IServiceClient? = null

    fun initialize(context: Context, url: String) {
        this.context = context
        //Making this an interface so someday maybe we can do this stuff offline and just cache it or some shit
        _serviceClient = OnlineServiceClient(context)
        sessionInformation = SessionInformation()
        this.url = url
    }

    fun execute(request: Request) {
        _serviceClient!!.execute(request)
    }

    companion object {
        private var _sparkNetworking: SparkNetworking? = null

        val instance: SparkNetworking
            get() {
                if (_sparkNetworking == null) {
                    _sparkNetworking = SparkNetworking()
                }
                return _sparkNetworking!!
            }
    }

}
