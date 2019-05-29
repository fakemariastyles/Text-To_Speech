package com.mmb.texttospeech.local.datasource

import com.mmb.texttospeech.local.service.FileService
import java.io.InputStream
import javax.inject.Inject

class SpeechLocalDataSource @Inject constructor(val service: FileService) {
    fun saveFile(inputStream: InputStream){
        service.saveFile(inputStream)
    }
}