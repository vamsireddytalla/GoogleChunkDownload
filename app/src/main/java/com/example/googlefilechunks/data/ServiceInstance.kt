package com.example.googlefilechunks.data

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ServiceInstance {

    var googleBaseUrl = "https://www.googleapis.com/drive/v3/files/";
    var productsBaseUrl = "https://fakestoreapi.com/";
    var endPoint:String = "11xy6_hKvulrXn9Sv6tVDEGP74zx6wrBv?supportsAllDrives=true&alt=media"
    var access_token:String = "Bearer ya29.a0AX9GBdW75Wyvt1lmDGltllTfE4bOk87jaVlmERt_c5n8acgAp_Lc643lKo1h-g52VaRkJCb7xhq_gylWgBkrWlV0BQeTeSjioUZhiffzGqLNH6P-Vew5vDPcMJOIJMu9dtMyy2lZp7S5y8lu9uct5jx_YFD_6d4aCgYKATUSAQASFQHUCsbCQNPXGKoHvuJowWWbccj53Q0166";
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