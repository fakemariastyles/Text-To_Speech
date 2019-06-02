package com.mmb.texttospeech.local.datasource

import android.content.Context
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream
import javax.inject.Inject

class SpeechLocalDataSource @Inject constructor(private val context: Context) {
    fun saveFile( success : () -> Unit ,inputStream: InputStream) {
        val file: File = File(context.filesDir, "speech.mp3")
        if (file.exists()) {
            file.delete()
        }
        inputStream.use { inputStream ->
            val output = FileOutputStream(file)
            output.use { output ->
                val buffer = ByteArray(4 * 1024)
                var read = inputStream.read(buffer)
                while (read != -1) {
                    output.write(buffer, 0, read)
                    read = inputStream.read(buffer)
                }
                output.flush()
            }
            output.close()
        }
        success()
    }
}