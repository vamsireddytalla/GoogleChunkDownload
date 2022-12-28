package com.example.googlefilechunks.data

import com.example.googlefilechunks.models.ProductModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @GET("files/19vdVjKzxCs2gn_OUoMP9-LGtUBCQOy0k?supportsAllDrives=true&alt=media")
    @Streaming
    fun streamVideoFile(@Header("Range") range:String,
                                @Header("Authorization") authHeader:String): Call<ResponseBody>

    @GET("products")
    fun getProducts():Call<ResponseBody>


    @POST("products")
    fun addProduct(@Body productModel:ProductModel):Call<ResponseBody>


    @PUT("products/7")
    fun updateProduct(@Body productModel:ProductModel):Call<ResponseBody>


    @PUT("delete/{id}")
    fun deleteProduct(@Path("id") id:Int):Call<ResponseBody>

}