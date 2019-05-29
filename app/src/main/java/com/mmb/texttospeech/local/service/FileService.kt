package com.mmb.texttospeech.local.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream

class FileService : Service() {
    private lateinit var file: File
    override fun onBind(intent: Intent?): IBinder? {
        println(filesDir)
        Log.v("SS", "onBind")
        return FileServiceBinder()
    }

    fun saveFile(inputStream: InputStream) {
        try {
            Log.v("SS" , "onSaveFile")
            var output: OutputStream = FileOutputStream(file)
            try {
                val buffer = ByteArray(4 * 1024)
                var read = inputStream.read(buffer)
                while (read != -1) {
                    output.write(buffer, 0, read)
                }
                output.flush()
            } finally {
                output.close()
            }
        } finally {
            inputStream.close()
        }

    }

    override fun onCreate() {
        super.onCreate()
        Log.v("SS", "onCreate")
        file = File(filesDir, "speech.mp3")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("SS", "onDestroy")
//        this.stopSelf()
    }
}