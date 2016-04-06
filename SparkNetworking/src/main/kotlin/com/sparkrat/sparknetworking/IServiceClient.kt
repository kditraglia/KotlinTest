package com.sparkrat.sparknetworking

import com.sparkrat.sparknetworking.requests.Request
import com.sparkrat.sparknetworking.responses.IResponseListener

interface IServiceClient {
    fun execute(request: Request)
}
