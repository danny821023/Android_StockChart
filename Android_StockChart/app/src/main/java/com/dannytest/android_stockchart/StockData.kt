import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("data")
    val stockDataList: List<StockData>
)

data class StockData(
    @SerializedName("股票代號")
    val stockId: String,
    @SerializedName("股票名稱")
    val stockName: String,
    @SerializedName("本益比基準")
    val peRatio: List<String>,
    @SerializedName("本淨比基準")
    val pbRatio: List<String>,
    @SerializedName("河流圖資料")
    val riverDataList: List<RiverData>  // 將河流圖資料改為 RiverData 的 List
)

data class RiverData(
    @SerializedName("年月")
    val yearMonth: String,
    @SerializedName("月平均收盤價")
    val monthAvgClosingPrice: String,
    @SerializedName("近四季EPS")
    val recentFourSeasonsEPS: String,
    @SerializedName("月近四季本益比")
    val monthRecentFourSeasonsPERatio: String,
    @SerializedName("本益比股價基準")
    val peRatioPriceBase: List<String>,
    @SerializedName("近一季BPS")
    val recentOneSeasonBPS: String,
    @SerializedName("月近一季本淨比")
    val monthRecentOneSeasonPBRatio: String,
    @SerializedName("本淨比股價基準")
    val pbRatioPriceBase: List<String>,
    @SerializedName("平均本益比")
    val avgPERatio: String,
    @SerializedName("平均本淨比")
    val avgPBRatio: String,
    @SerializedName("近3年年複合成長")
    val recentThreeYearsCompoundedGrowth: String
)
