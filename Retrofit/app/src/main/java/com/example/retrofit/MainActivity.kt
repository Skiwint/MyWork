package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.retrofit.Models.UrlModels
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        BTN.setOnClickListener { SupRetrofit() }
    }

    fun SupRetrofit(){
        var builder = Retrofit.Builder().baseUrl("https://aws.random.cat/").addConverterFactory(GsonConverterFactory.create())
        var retrofit = builder.build()
        var ApiItn: ApiItn = retrofit.create<ApiItn>(ApiItn::class.java)
        var call: retrofit2.Call<UrlModels> = ApiItn.getFile()
        call.enqueue(object : Callback<UrlModels> {

            override fun onResponse(call: Call<UrlModels>, response: Response<UrlModels>) {
                Tv.text = response.body()!!.file
            }

            override fun onFailure(call: Call<UrlModels>, t: Throwable) {
                Log.i("NO", t.message.toString())
            }
        }
        )


    }
}