package com.mmb.texttospeech

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.mmb.texttospeech.app.TextToSpeechApp
import com.mmb.texttospeech.data.repository.SpeechRepository
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var speechRepository: SpeechRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        TextToSpeechApp.component.inject(this)
        speechRepository.textToSpeech("en-us" , "Hello")
    }
}
