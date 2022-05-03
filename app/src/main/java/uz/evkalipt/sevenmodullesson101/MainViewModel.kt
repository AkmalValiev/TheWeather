package uz.evkalipt.sevenmodullesson101

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.evkalipt.sevenmodullesson101.models.Weather

class MainViewModel:ViewModel() {

    private val liveData = MutableLiveData<Weather>()

    fun getWeather(lat:String, lon:String, api:String):LiveData<Weather>{
        ApiClient.getRetrofit().create(ApiService::class.java).getWeather(lat, lon, api).enqueue(object :Callback<Weather>{
            override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                if (response.isSuccessful){
                    liveData.value = response.body()
                }
            }

            override fun onFailure(call: Call<Weather>, t: Throwable) {

            }

        })

        return liveData
    }

}