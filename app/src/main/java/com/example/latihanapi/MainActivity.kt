package com.example.latihanapi

import android.os.Bundle
import android.util.Log.e
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.latihanapi.adapters.MainAdapter
import com.example.latihanapi.models.ModelProduct
import com.example.latihanapi.utils.ApiClient
import com.example.latihanapi.utils.ApiInterface
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rcMain.layoutManager = LinearLayoutManager(this)
        getData()
    }

    fun getData() {
        val apiInterface = ApiClient().getClient().create(ApiInterface::class.java)
        apiInterface.getProduct().enqueue(object : Callback<ArrayList<ModelProduct>> {
            override fun onResponse(
                call: Call<ArrayList<ModelProduct>>,
                response: Response<ArrayList<ModelProduct>>
            ) {
                if (response.code() == 200) {
                    rcMain.adapter = MainAdapter(this@MainActivity, response.body()!!)
                } else {
                    Toast.makeText(this@MainActivity, "Error Server", Toast.LENGTH_SHORT).show()
                    e("error", "Kesalahan server")
                }
            }

            override fun onFailure(call: Call<ArrayList<ModelProduct>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "error connection", Toast.LENGTH_SHORT).show()
                e("error", t.message, t)
            }

        })
    }
}
