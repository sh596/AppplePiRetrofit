package com.example.retrofit

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.retrofit.MusicClient.service
import com.example.retrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)


        val call : Call<RetrofitData> = service().getChart("563f17153e9c60240d5e29bb1a508549")
        call.enqueue(object : Callback<RetrofitData> {
            override fun onResponse(call: Call<RetrofitData>, response: Response<RetrofitData>) {
                if(!response.isSuccessful){
                    Log.d(TAG, "onResponse: 실패" + response.code())
                    return
                }
                Log.d(TAG, "onResponse: 성공" + response.code())
                binding.recyclerView.adapter = MusicAdapter(response.body()!!.tracks.track)

            }

            override fun onFailure(call: Call<RetrofitData>, t: Throwable) {
                Log.d(TAG, "onResponse: 실패" + t.message)
            }
        })
    }
}