package com.mmb.texttospeech.remote.datasource

import com.mmb.texttospeech.remote.api.TextToSpeechApi
import io.reactivex.Single
import java.io.InputStream
import javax.inject.Inject

class SpeechRemoteDataSource @Inject constructor(private val textToSpeechApi: TextToSpeechApi){
    fun TextToSpeech(language : String? , text: String):Single<InputStream>{
        return textToSpeechApi.convertTextToSpeech(KEY, language , text).map {
            it.byteStream()
        }
    }
    companion object{
        const val KEY = "d661915369804db5ac15928913567c99"
    }
}