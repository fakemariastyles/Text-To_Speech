package com.mmb.texttospeech.app

import android.os.Bundle
import android.view.View
import android.widget.*
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
        var speed = findViewById<TextView>(R.id.speed)
        val editText = findViewById<EditText>(R.id.text)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val adapter = ArrayAdapter.createFromResource(
            this
            , R.array.languages, android.R.layout.simple_spinner_dropdown_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        spinner.adapter = adapter


        findViewById<View>(R.id.up).setOnClickListener {
            val s = speed.text.toString().toInt()
            if (s < 10) speed.text = (s + 1).toString()
        }

        findViewById<View>(R.id.down).setOnClickListener {
            val s = speed.text.toString().toInt()
            if (s > -10) speed.text = (s - 1).toString()
        }


        findViewById<View>(R.id.play).setOnClickListener {
            editText.text.toString().let {
                if (speechRepository.isConnectedToInternet()) {
                    speechRepository.textToSpeech(
                        getLanguage(spinner)
                        , text = it
                        , speed = speed.text.toString().toInt()
                    )
                } else {
                    Toast.makeText(this, "Connect to internet first", Toast.LENGTH_LONG)
                        .show()
                }
            }
        }
    }

    private fun getLanguage(spinner: Spinner): String {
        return spinner.selectedItem.toString()
    }
}
