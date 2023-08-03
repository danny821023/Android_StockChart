package com.dannytest.android_stockchart

import kotlinx.serialization.SerialName
import java.io.Serializable

data class stockData(
    var data: List<StockData>?
) {
    data class StockData(
        val sign: String,
        val name: String,
        val peb: List<String>,
        val ctn: List<String>,
        val rivermap: List<RiverMapData>,
        val cpe: String,
        val cnr: String,
        val mpe: String,
        val mpn: String,
        val rse: String,
        val pra: String,
        val aer: String,
        val anr: String,
        val per: String
    ): Serializable

    data class RiverMapData(
        val ym: String,
        val macp: String,
        @SerialName("近四季EPS")
        val feps: String,
        val pefm: String,
        val pspb: List<String>,
        @SerialName("近一季BPS")
        val lqb: String,
        val mqnr: String,
        val psb: List<String>,
        val aper: String,
        val avern: String,
        val ginthree: String? = null
    ): Serializable
}

//DataTwo
//股票代號-sign
//股票名稱 -name
//本益比基準 - peb
//本淨比基準 - ctn
//河流圖資料 -rivermap
//目前本益比 -cpe
//目前本淨比 -cnr
//同業本益比中位數 - mpe
//同業本淨比中位數 - mpn
//本益比股價評估 - rse
//本淨比股價評估 - pra
//平均本益比 - aer
//平均本淨比 -anr
//本益成長比 -per

//DataThree
// 年月 - ym
//月平均收盤價 - macp
// 近四季Eps - feps
//月近四季本益比 -pefm
// 本益比股價基準 -pspb
//近一季Bps - lqb
//月近一季本淨比 - mqnr
//本淨比股價基準 - psb
//平均本益比 -aper
//平均本淨比 - avern
// 近3年年複合成長 - ginthree