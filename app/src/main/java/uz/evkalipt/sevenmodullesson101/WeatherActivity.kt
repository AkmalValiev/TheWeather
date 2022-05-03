package uz.evkalipt.sevenmodullesson101

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import uz.evkalipt.sevenmodullesson101.databinding.ActivityWeatherBinding

class WeatherActivity : AppCompatActivity() {
    lateinit var binding: ActivityWeatherBinding
    lateinit var mainViewModel: MainViewModel
    var icon:String? = null
    var weatherId:Int? = null
    var name:String? = null
    var degrees:Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val lat = intent.getDoubleExtra("lat", 0.0)
        val long = intent.getDoubleExtra("long", 0.0)
        val api = "7dc4abe09751ffb66fbaf400b745dfeb"

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.getWeather(lat.toString(), long.toString(), api).observe(this, {
            icon = it.weather[0].icon
            weatherId = it.weather[0].id
            name = it.name
            degrees = it.main.temp.toInt()-273
            binding.degree.text = degrees.toString()
            binding.place.text = name
            binding.description.text = it.weather[0].description
            if (weatherId!! in 200..232){
                binding.container.setBackgroundResource(R.drawable.thunderstorm)
                binding.image.setImageResource(R.drawable.thuderstorm)
            }else if (weatherId!! in 300..321 || weatherId!! in 500..531){
                binding.container.setBackgroundResource(R.drawable.drizzle_rain)
                binding.image.setImageResource(R.drawable.drizzle1)
            }else if (weatherId!! in 600..622){
                binding.container.setBackgroundResource(R.drawable.snow)
                binding.image.setImageResource(R.drawable.snow1)
            }else if (weatherId!! in 701..781){
                binding.container.setBackgroundResource(R.drawable.mist)
                binding.image.setImageResource(R.drawable.haze1)
            }else if (weatherId!! in 801..804){
                binding.container.setBackgroundResource(R.drawable.clouds)
                binding.image.setImageResource(R.drawable.cloud1)
            }else if (weatherId==800){
                binding.container.setBackgroundResource(R.drawable.clear)
                binding.image.setImageResource(R.drawable.sun1)
            }
        })

    }
}