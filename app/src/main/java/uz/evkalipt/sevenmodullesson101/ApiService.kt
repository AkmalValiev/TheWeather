package uz.evkalipt.sevenmodullesson101

import android.view.View
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import uz.evkalipt.sevenmodullesson101.models.Weather

interface ApiService {

    @GET("data/2.5/weather?")
    fun getWeather(@Query("lat") lat:String, @Query("lon") lon:String, @Query("appid") api:String):Call<Weather>
}