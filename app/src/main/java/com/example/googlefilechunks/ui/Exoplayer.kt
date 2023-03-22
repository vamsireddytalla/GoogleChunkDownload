package com.example.googlefilechunks.ui

import android.media.browse.MediaBrowser
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.googlefilechunks.data.ServiceInstance
import com.example.googlefilechunks.databinding.ActivityExoplayerBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory
import com.google.android.exoplayer2.upstream.DefaultDataSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource

class Exoplayer : AppCompatActivity()
{
    lateinit var binding: ActivityExoplayerBinding
    var videoUrl="http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityExoplayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Creates a default datasource factory
        val dataSourceFactory:DefaultDataSource.Factory = DefaultDataSource.Factory(this);
        val mediaSourceFactory = DefaultMediaSourceFactory(headers())

        val videoUri = Uri.parse(ServiceInstance.googleBaseUrl+ServiceInstance.endPoint)
        //create a mediasource
        val mediaSource = mediaSourceFactory.createMediaSource(MediaItem.fromUri("https://www.googleapis.com/drive/v3/files/1xfdYC6P0chygRMwFk7PUbv1E5Qw5xHwc?supportsTeamDrives=true&supportsAllDrives=true&teamDriveId='0ABAYT8v9oaEoUk9PVA'&alt=media"))
//        val mediaSource1 = ExtractorMediaSource.Factory(dataSourceFactory).createMediaSource(videoUri)
        // 3. Create a SimpleExoPlayer and prepare the player with the media source
        val player = ExoPlayer.Builder(this).build()
        player?.playWhenReady = true
        binding.playerView.player=player
        player?.setMediaSource(mediaSource)
        player?.prepare()
    }

    fun headers(): com.google.android.exoplayer2.upstream.DataSource.Factory {
        val headersMap: MutableMap<String, String> = HashMap()
        headersMap["Authorization"] = ServiceInstance.access_token
//        headersMap["Range"]="bytes=0-1400000"
        return DefaultHttpDataSource.Factory().setDefaultRequestProperties(headersMap)
    }


}