package com.mmb.texttospeech.app

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
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
        val spinner = findViewById<Spinner>(R.id.spinner)
        val adapter = ArrayAdapter.createFromResource(this
            , R.array.languages , android.R.layout.simple_spinner_dropdown_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        spinner.adapter = adapter



        findViewById<View>(R.id.play).setOnClickListener {
            editText.text.toString().let {
                if (speechRepository.isConnectedToInternet()) {
                    speechRepository.textToSpeech(
                        getLanguage(spinner)
                        , text = it)
                } else {
                    Toast.makeText(this, "Connect to internet first", Toast.LENGTH_LONG)
                        .show()
                }
            }
        }
    }
    private fun getLanguage(spinner : Spinner):String{
        return spinner.selectedItem.toString()
    }
}
