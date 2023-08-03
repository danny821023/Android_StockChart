package com.dannytest.android_stockchart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class StockViewModel : ViewModel() {
    // 定義 LiveData 來存儲 API 回傳的資料
    private val _petsItemList = MutableLiveData<List<stockData.StockData>>()
    val petsItemList: LiveData<List<stockData.StockData>>
        get() = _petsItemList

    // 定義 LiveData 來存儲錯誤訊息
    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    // 定義 ApiManager 物件
    private val apiManager = ApiManager

    // ViewModel 函式，用於從 API 獲取資料
    fun fetchDataFromApi() {
        apiManager.fetchDataFromApi { petItems, errorMessage ->
            if (errorMessage != null) {
                // 處理 API 請求失敗的情況
                _error.postValue(errorMessage)
            } else {
                // 處理 API 回傳的資料
                _petsItemList.postValue(petItems)
            }
        }
    }




}