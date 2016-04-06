package com.sparkrat.sparknetworking

import android.content.Context
import android.os.AsyncTask
import android.util.Base64
import android.util.Log
import com.sparkrat.sparknetworking.requests.Request
import org.json.JSONObject
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


class OnlineServiceClient(context: Context) : IServiceClient {

    override fun execute(request: Request) {
        ExecuteTask(request).execute()
    }

    class ExecuteTask(val request: Request) : AsyncTask<Void, Void, String>() {

        override fun doInBackground(vararg params: Void?): String? {
            val url: URL = URL(SparkNetworking.instance.url + request.requestName)
            val conn: HttpURLConnection = url.openConnection() as HttpURLConnection

            conn.readTimeout = 10000
            conn.connectTimeout = 15000
            conn.requestMethod = request.requestType
            conn.doInput = true

            conn.setRequestProperty("Authorization", request.authToken)
            conn.connect()

            val inputStream = conn.getInputStream();
            val reader = InputStreamReader(inputStream, "UTF-8")

            val builder = StringBuilder()
            reader.forEachLine {
                builder.appendln(it)
            }
            return builder.toString()
        }

        override fun onPostExecute(result: String?) {
            val json = JSONObject(result!!)
            val map = Serialization.jsonToMap(json)

            Log.d("reponse: ", result)
        }
    }
}