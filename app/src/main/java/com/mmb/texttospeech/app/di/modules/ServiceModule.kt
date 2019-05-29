package com.mmb.texttospeech.app.di.modules

import android.content.Context
import android.content.Intent
import com.mmb.texttospeech.app.TextToSpeechApp
import com.mmb.texttospeech.local.service.FileService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ServiceModule {
    @Provides
    @Singleton
    fun provideFileService(context : Context): FileService{
        val service = FileService()
        context.startService( Intent(context, FileService::class.java))
        return service
    }
}