package com.mmb.texttospeech.app.di.modules

import com.mmb.texttospeech.remote.api.TextToSpeechApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofitInterface():Retrofit{
        return Retrofit.Builder()
            .baseUrl(TextToSpeechApi.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideTextToSpeechApi(retrofit: Retrofit):TextToSpeechApi{
        return retrofit.create(TextToSpeechApi::class.java)
    }

}