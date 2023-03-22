package com.example.googlefilechunks.data

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ServiceInstance {

    var googleBaseUrl = "https://www.googleapis.com/drive/v3/files/";
    var productsBaseUrl = "https://fakestoreapi.com/";
    var endPoint:String = "1qEV80rs3XA11S8q416MpmjHAJoIzwyok?supportsTeamDrives=true&supportsAllDrives=true&teamDriveId='0AAdumyz7IQnPUk9PVA'&alt=media"
    var access_token:String = "Bearer ya29.a0AVvZVsrpHy3gPoZAwDIRAbCLAocZtPjYOENs3g075FzWZBpnkh_u49bcHVNz24LfgrCG_oGprDk0jf-p4ygtAYhnznKDma4RpeJiRvMue5ro3cxMzUZIkMWEqlt82LOfAdBNV9mwSB3KSsmaTOMPgmgS7k8hzScaCgYKAVcSAQASFQGbdwaIQTbdYMwjgxqF92jjhqHzIg0166";
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