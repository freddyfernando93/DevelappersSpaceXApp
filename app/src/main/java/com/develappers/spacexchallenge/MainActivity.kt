package com.develappers.spacexchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView =  findViewById<RecyclerView>(R.id.launchesRecyclerView)
        val loadingProgressBar = findViewById<ProgressBar>(R.id.loadingSpinner)

        val serviceGenerator = ServiceGenerator.buildService(ApiService::class.java)
        val call = serviceGenerator.getLaunches()
        loadingProgressBar.visibility = View.VISIBLE
        call.enqueue(object : Callback<MutableList<LaunchModel>> {
            override fun onResponse(call: Call<MutableList<LaunchModel>>, response: Response<MutableList<LaunchModel>>) {
                if(response.isSuccessful){
                    loadingProgressBar.visibility = View.INVISIBLE
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        adapter = LaunchAdapter(response.body()!!)
                    }
                }
            }

            override fun onFailure(call: Call<MutableList<LaunchModel>>, t: Throwable) {
                loadingProgressBar.visibility = View.INVISIBLE
                t.printStackTrace()
                Log.e("error", t.message.toString())
            }

        })
    }
}