package com.mmb.texttospeech.remote.datasource

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.mmb.texttospeech.remote.api.TextToSpeechApi
import io.reactivex.Single
import java.io.InputStream
import javax.inject.Inject

class SpeechRemoteDataSource @Inject constructor(private val textToSpeechApi: TextToSpeechApi) {
    fun textToSpeech(language: String?, text: String?, speed: Int?): Single<InputStream> {
        return textToSpeechApi.convertTextToSpeech(KEY, language, text, speed).map {
            println(it)
            it.byteStream()
        }
    }

    fun isConnectedToInternet(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        return activeNetwork?.isConnected == true

    }

    companion object {
        const val KEY = "d661915369804db5ac15928913567c99"
    }
}