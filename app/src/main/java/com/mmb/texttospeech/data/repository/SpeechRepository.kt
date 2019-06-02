package com.mmb.texttospeech.data.repository

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import com.mmb.texttospeech.local.datasource.SpeechLocalDataSource
import com.mmb.texttospeech.mediaplayer.AudioPlayer
import com.mmb.texttospeech.remote.datasource.SpeechRemoteDataSource
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.io.InputStream
import javax.inject.Inject

class SpeechRepository @Inject constructor(
    private val context: Context,
    private val speechLocalDataSource: SpeechLocalDataSource
    , private val speechRemoteDataSource: SpeechRemoteDataSource
) {

    @SuppressLint("CheckResult")
    fun textToSpeech(language: String?, text: String?) {
        Log.v("SS", "requesting")
        speechRemoteDataSource.textToSpeech(language, text)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe({
                println(it)
                saveSpeech(Single.just(it))
            }, {
                println(it)
            })
    }

    @SuppressLint("CheckResult")
    private fun saveSpeech(inputStream: Single<InputStream>) {
        Log.v("SS", "onSaveSpeechRepo")
        inputStream.subscribeOn(Schedulers.io())
            .doOnSuccess {
                speechLocalDataSource.saveFile(::onFileSaved,it)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
            }, {
            })
    }

    private fun onFileSaved(){
        Log.v("SS" , "onFileSaved")
        AudioPlayer(context = context, file = context.openFileInput("speech.mp3")).play()
    }

    fun isConnectedToInternet() = speechRemoteDataSource.isConnectedToInternet(context)
}