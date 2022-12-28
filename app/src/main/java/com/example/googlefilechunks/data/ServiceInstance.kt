package com.example.googlefilechunks.data

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ServiceInstance {

    var googleBaseUrl = "https://www.googleapis.com/drive/v3/";
    var productsBaseUrl = "https://fakestoreapi.com/";
    var endPoint:String = "19vdVjKzxCs2gn_OUoMP9-LGtUBCQOy0k?supportsAllDrives=true&alt=media"
    var access_token:String = "Bearer ya29.a0AX9GBdWJDIXMpdb4Mv3rpi11Leg8tyEJheBqTnLkWTKq9sB9-Fjy5yQCYBrlmHRb-Z_Nx8u5f3Ys2YXFQOlJWBs06mzFRWfl9I6t5LmWbX7AiF58eZzllxs22T-2VMEJW-7AYf-D71STzOZP5GmyN403gj9_aCgYKARASARESFQHUCsbCB9SCF6C8_ahpDBwxu_AR1Q0163";
    fun getInstance(): Retrofit {
        var mHttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        var mOkHttpClient = OkHttpClient
            .Builder()
            .addInterceptor(mHttpLoggingInterceptor)
            .build()

        val gson = GsonBuilder()
            .setLenient()
            .create()

        var retrofit: Retrofit = retrofit2.Retrofit.Builder()
            .baseUrl(googleBaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(mOkHttpClient)
            .build()
        return retrofit
    }

}