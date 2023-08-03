package com.dannytest.android_stockchart

import ApiResponse
import RiverData
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import java.util.*
import kotlin.math.log

object ApiManager {

    private val client = OkHttpClient()

    fun fetchDataFromApi(callback: (List<RiverData>?, String?) -> Unit) {
        Log.d("dev start api", "start")

        val request = Request.Builder()
            .url("https://api.nstock.tw/v2/per-river/interview?stock_id=2330")
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                // 處理請求失敗的情況
                Log.d("dev start fail", e.toString())
                callback(null, "API請求失敗")
            }

            override fun onResponse(call: Call, response: Response) {
                // 處理請求成功的情況
                Log.d("AnimalViewModel", "API 請求成功")
                if (response.isSuccessful) {
                    val responseData = response.body?.string() ?: ""
                    Log.d("AnimalViewModel 122", responseData)

                    if (!responseData.isNullOrEmpty()) {
                        // 使用 Gson 解析 JSON 資料
                        val gson = Gson()
                        val stockData = gson.fromJson(responseData, ApiResponse::class.java)

                        callback(stockData.stockDataList.first().riverDataList, responseData.toString())
                        Log.d("dev 132", stockData.stockDataList.first().riverDataList.toString())


                    } else {
                        // 處理回應為空的情況
                        callback(null, "API回應為空")
                    }
                } else {
                    // 處理請求失敗的情況
                    Log.d("AnimalViewModel", "API解析失敗")
                    callback(null, "API解析失敗")
                }
            }
        })
    }
}





