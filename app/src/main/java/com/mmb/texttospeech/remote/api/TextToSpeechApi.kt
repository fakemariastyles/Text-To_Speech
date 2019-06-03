package com.mmb.texttospeech.remote.api

import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface TextToSpeechApi {
    @GET("/?")
    fun convertTextToSpeech(
        @Query("key") key: String?
        , @Query("hl") language: String?
        , @Query("src") text: String?
        , @Query("r") speed: Int?
    ): Single<ResponseBody>

    companion object {
        const val BASE_URL = "http://api.voicerss.org"
    }
}