package com.mmb.texttospeech.app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mmb.texttospeech.R
import com.mmb.texttospeech.data.repository.SpeechRepository
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var speechRepository: SpeechRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_text_to_speech_layout)
        TextToSpeechApp.component.inject(this)


        val editText = findViewById<EditText>(R.id.text)



        findViewById<Button>(R.id.play).setOnClickListener {
            editText.text.toString().let {
                if(speechRepository.isConnectedToInternet()){
                    speechRepository.textToSpeech("en-us", text = it)
                }
                else{
                    Toast.makeText(this, "Connect to internet first" , Toast.LENGTH_LONG)
                        .show()
                }

            }
        }


    }
}
