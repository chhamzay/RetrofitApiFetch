package com.example.retrofiltsapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.provider.Settings.Global
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofiltsapi.Adapter.ProductAdapter
import com.example.retrofiltsapi.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    private lateinit var adapter:ProductAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val retrofitBuilder = RetrofitBuilder.getInstance().create(ApiInterface::class.java)

        val  retrofitdata = retrofitBuilder.getProductData()

        retrofitdata.enqueue(object : Callback<ApiData?> {
            override fun onResponse(call: Call<ApiData?>, response: Response<ApiData?>) {
                val responsedata = response.body()

                if(responsedata!=null){
                    adapter = ProductAdapter(responsedata)
                    binding.recyclerview.layoutManager = LinearLayoutManager(applicationContext)
                    binding.recyclerview.adapter = adapter
                }
            }

            override fun onFailure(call: Call<ApiData?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })





    }
}