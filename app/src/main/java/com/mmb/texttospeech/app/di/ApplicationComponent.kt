package com.mmb.texttospeech.app.di

import com.mmb.texttospeech.app.TextToSpeechApp
import com.mmb.texttospeech.app.di.modules.AppModule
import com.mmb.texttospeech.app.di.modules.NetworkModule
import dagger.Component


@Component(modules = [NetworkModule::class , AppModule::class])
interface ApplicationComponent {
    fun inject(app: TextToSpeechApp)
}