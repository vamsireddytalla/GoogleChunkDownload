package com.example.googlefilechunks.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.googlefilechunks.R
import com.example.googlefilechunks.data.ApiInterface
import com.example.googlefilechunks.data.ServiceInstance
import com.example.googlefilechunks.databinding.ActivityMainBinding
import com.example.googlefilechunks.databinding.ActivitySecondBinding
import com.example.googlefilechunks.models.ProductModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

private const val TAG = "SecondActivity"

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding
    lateinit var apiInterface: ApiInterface


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.get.setOnClickListener {
            apiInterface = ServiceInstance.getInstance().create(ApiInterface::class.java)
            GlobalScope.launch(Dispatchers.IO) {
                getProducts()
            }
        }
        binding.post.setOnClickListener {
            apiInterface = ServiceInstance.getInstance().create(ApiInterface::class.java)
            GlobalScope.launch(Dispatchers.IO) {
                addProduct()
            }
        }
        binding.update.setOnClickListener {
            apiInterface = ServiceInstance.getInstance().create(ApiInterface::class.java)
            GlobalScope.launch(Dispatchers.IO) {
                updateProduct()
            }
        }
        binding.delete.setOnClickListener {
            apiInterface = ServiceInstance.getInstance().create(ApiInterface::class.java)
            GlobalScope.launch(Dispatchers.IO) {
                deleteProduct()
            }
        }


    }

    suspend fun getProducts() {
        apiInterface.getProducts().enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                Log.d(TAG, "***************GET SUCCESS *********************")
                Log.d(TAG, "onResponse: Success ${response.body().toString()}")
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }
        })
    }

    suspend fun addProduct() {
        apiInterface.addProduct(
            ProductModel(
                "test product",
                13.5,
                "lorem ipsum set",
                "https://i.pravatar.cc",
                "electronic"
            )
        ).enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                Log.d(TAG, "***************POST SUCCESS *********************")
                Log.d(TAG, "onResponse: Success ${response.body().toString()}")
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }
        })
    }

    suspend fun updateProduct() {
        apiInterface.updateProduct(
            ProductModel(
                "test product",
                13.5,
                "lorem ipsum set",
                "https://i.pravatar.cc",
                "electronic"
            )
        ).enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                Log.d(TAG, "***************UPDATE SUCCESS *********************")
                Log.d(TAG, "onResponse: Success ${response.body().toString()}")
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }
        })
    }

    suspend fun deleteProduct() {
        apiInterface.deleteProduct(6).enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                Log.d(TAG, "***************Delete SUCCESS *********************")
                Log.d(TAG, "onResponse: Success ${response.body().toString()}")
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }
        })
    }

}