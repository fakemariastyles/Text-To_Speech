package com.mmb.texttospeech.data.repository

import com.mmb.texttospeech.local.datasource.SpeechLocalDataSource
import com.mmb.texttospeech.remote.datasource.SpeechRemoteDataSource
import io.reactivex.schedulers.Schedulers
import java.io.InputStream
import javax.inject.Inject

class SpeechRepository @Inject constructor(
    private val speechLocalDataSource: SpeechLocalDataSource
    ,private val speechRemoteDataSource: SpeechRemoteDataSource
) {

    fun textToSpeech(language: String? , text: String?){
        speechRemoteDataSource.TextToSpeech(language,text)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe({
                println(it)
                saveSpeech(it)
            },{
                println(it)
            })
    }

    private fun saveSpeech(inputStream: InputStream){
        speechLocalDataSource.saveFile(inputStream)
    }
}