package com.mmb.texttospeech.mediaplayer

import android.content.Context
import android.media.MediaPlayer
import android.util.Log
import java.io.*


class AudioPlayer(private val file: InputStream, private val context: Context) : MediaPlayer() {
    private var mediaPlayer : MediaPlayer? = null
    fun play() {
        val inputStream = context.openFileInput("speech.mp3")
        mediaPlayer = MediaPlayer()
        mediaPlayer?.setDataSource(inputStream.fd)
        mediaPlayer?.prepare()
        mediaPlayer?.start()
    }
}