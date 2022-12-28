package com.example.googlefilechunks.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ServiceInstance {

    var googleBaseUrl = "https://www.googleapis.com/drive/v3/";
    var productsBaseUrl = "https://fakestoreapi.com/";
    var endPoint:String = "19vdVjKzxCs2gn_OUoMP9-LGtUBCQOy0k?supportsAllDrives=true&alt=media"
    var access_token:String = "Bearer ya29.a0AX9GBdUeDqDXjJOQbRTz3Di_-P3xduG_NcceDPPsDXC07OUGU7Sd8gMuogxjHxdbY2eCD7uOT9oCy4lGF5akciquNnKYnhRb25PxTgK3086Rc4_SjqbpF6s_iCleLz2uUAfwAKfglB_MCKzD-b4n5nIvcQvgaCgYKAVoSARESFQHUCsbCliqPdqCL64xJsHMttDzCxw0163";
    fun getInstance(): Retrofit {
        var mHttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        var mOkHttpClient = OkHttpClient
            .Builder()
            .addInterceptor(mHttpLoggingInterceptor)
            .build()


        var retrofit: Retrofit = retrofit2.Retrofit.Builder()
            .baseUrl(productsBaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(mOkHttpClient)
            .build()
        return retrofit
    }

}