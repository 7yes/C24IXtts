package com.example.tts01

import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tts01.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale
import java.util.Objects

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    private lateinit var binding: ActivityMainBinding
    private var tts: TextToSpeech? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        tts = TextToSpeech(this, this)
//        binding.ivMic.setOnClickListener { callMic() }
//        binding.ivSpeaker.setOnClickListener { speak() }
    }

    private fun callMic() {
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Numina Speech App")
        Log.d("TAJ", "onCreate: ${Locale.getDefault()} ")
        try {
            startActivityForResult(intent, 1)
        } catch (e: Exception) {
            Toast.makeText(this, " ff " + e.message, Toast.LENGTH_LONG).show()
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("TAJ", "onActivityResult: $requestCode")
        if (requestCode == 1) {
            if (resultCode == RESULT_OK && data != null) {
                val res: ArrayList<String> =
                    data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS) as ArrayList<String>
                Log.d("TAJ", "onActivityResult: ${Objects.requireNonNull(res[0])}")
               // binding.tvText.text = Objects.requireNonNull(res[0]) + " from Numina group"
            }
        }
    }

    private fun speak() {
       // val text = binding.tvText.text.toString()
        //tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
    }


    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            var output = tts?.setLanguage(Locale.getDefault())
            if (output == TextToSpeech.LANG_MISSING_DATA || output == TextToSpeech.LANG_NOT_SUPPORTED) {
                Toast.makeText(this, "Languaje is not supported", Toast.LENGTH_SHORT).show()
            }
        }
    }

}