package com.example.mediaplayer

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        mediaPlayer = MediaPlayer.create(this,R.raw.unavailable)
//        mediaPlayer?.start()

        playButton.setOnClickListener {
            if (mediaPlayer == null) { //미디어플레이어가 널일때만 새로 초기화해줌
                mediaPlayer = MediaPlayer.create(this, R.raw.unavailable)
            }
            mediaPlayer?.start()
        }
        pauseButton.setOnClickListener {
            if (mediaPlayer?.isPlaying == true) {
                mediaPlayer?.pause()
            } else {
                mediaPlayer?.start()
            }
        }
        stopButton.setOnClickListener {
            mediaPlayer?.stop()
            mediaPlayer = null
        }
    }
    override fun onStop(){
        super.onStop()
        mediaPlayer?.release()
        mediaPlayer = null

    }
}