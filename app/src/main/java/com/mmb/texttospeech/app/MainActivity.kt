package com.mmb.texttospeech.app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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


        val editText = findViewById<EditText>(R.id.text)
//        speechRepository.textToSpeech("en-us", "Hello Maryam")
        findViewById<Button>(R.id.play).setOnClickListener {
            editText.text.toString().let {
                println(it)
                speechRepository.textToSpeech("en-us", text = it)
                speechRepository.play(this)
            }
        }


    }
}
