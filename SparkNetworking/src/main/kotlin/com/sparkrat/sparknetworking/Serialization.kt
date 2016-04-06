package com.sparkrat.sparknetworking

import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

import java.util.ArrayList
import java.util.HashMap

object Serialization {

    fun jsonToMap(json: JSONObject): Map<String, Any> {
        var retMap: Map<String, Any> = HashMap<String, Any>()

        if (json !== JSONObject.NULL) {
            retMap = toMap(json)
        }
        return retMap
    }

    fun toMap(`object`: JSONObject): Map<String, Any> {
        val map = HashMap<String, Any>()

        val keysItr = `object`.keys()
        while (keysItr.hasNext()) {
            val key = keysItr.next()
            var value: Any = `object`.get(key)

            if (value is JSONArray) {
                value = toList(value as JSONArray)
            } else if (value is JSONObject) {
                value = toMap(value as JSONObject)
            }
            map.put(key, value)
        }
        return map
    }

    fun toList(array: JSONArray): List<Any> {
        val list = ArrayList<Any>()
        for (i in 0..array.length() - 1) {
            var value: Any = array.get(i)
            if (value is JSONArray) {
                value = toList(value as JSONArray)
            } else if (value is JSONObject) {
                value = toMap(value as JSONObject)
            }
            list.add(value)
        }
        return list
    }
}
