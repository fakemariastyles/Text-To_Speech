package com.mmb.texttospeech.app

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.mmb.texttospeech.R
import com.mmb.texttospeech.data.repository.SpeechRepository
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var speechRepository: SpeechRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_text_to_speech_layout)
        TextToSpeechApp.component.inject(this)
        speechRepository.textToSpeech("en-us", "Hello")
        findViewById<Button>(R.id.play).setOnClickListener {
            speechRepository.play(this)
        }
    }
}
