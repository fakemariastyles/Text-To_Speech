package com.mmb.texttospeech.app

import android.app.Application
import com.mmb.texttospeech.app.di.ApplicationComponent
import com.mmb.texttospeech.app.di.DaggerApplicationComponent
import com.mmb.texttospeech.app.di.modules.AppModule

class TextToSpeechApp : Application() {
    override fun onCreate() {
        super.onCreate()
        component = DaggerApplicationComponent
            .builder()
            .appModule(AppModule(this))
            .build()
        component.inject(this)
    }

    companion object {
        lateinit var component: ApplicationComponent
    }
}