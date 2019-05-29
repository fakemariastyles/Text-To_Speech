package com.mmb.texttospeech.app.di.modules

import android.content.Context
import com.mmb.texttospeech.app.TextToSpeechApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app : TextToSpeechApp) {
    @Provides
    @Singleton
    fun provideContext(): Context {
        return app.applicationContext
    }

}