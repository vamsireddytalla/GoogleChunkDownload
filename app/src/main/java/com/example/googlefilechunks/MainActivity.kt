package com.example.googlefilechunks

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.googlefilechunks.data.ApiInterface
import com.example.googlefilechunks.data.ServiceInstance
import com.example.googlefilechunks.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity()
{
    lateinit var binding:ActivityMainBinding
    var startBytes:Double = 0.0;
    var endBytes:Double = 0.0;
    var totalFileSize=0.0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.b1.setOnClickListener{
            GlobalScope.launch {
                var serviceReq = ServiceInstance.getInstance().create(ApiInterface::class.java)
                serviceReq.streamVideoFile("bytes=500-29000000",ServiceInstance.access_token).enqueue(object :Callback<ResponseBody>{
                    override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                        try {
                            if (response.isSuccessful)
                            {
                                Log.d(TAG, "onResponse: Success")
                                val input: InputStream = response.body()!!.byteStream()
                                val file = File(cacheDir, "myVideo.mp4")
                                FileOutputStream(file).use { output ->
                                    val buffer = ByteArray(4 * 1024) // or other buffer size
                                    var read: Int
                                    while (input.read(buffer).also { read = it } != -1) {
                                        output.write(buffer, 0, read)
                                    }
                                    output.flush()
                                }
                                input.close()
                            }else{
                                Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_SHORT).show()
                            }
                        }catch (e:Exception){
                            e.printStackTrace()
                        }finally {

                        }
                    }
                    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                        Log.d(TAG, "onFailure: ${t.message}")
                    }
                })
            }
        }

    }

}