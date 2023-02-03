package com.example.ipp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.ipp.databinding.ActivityMainBinding
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Example of a call to a native method
        binding.sampleText.text = stringFromJNI()

        val btn =  findViewById(R.id.btnTest) as Button
        btn.setOnClickListener{
            Toast.makeText(this@MainActivity, "Hello world", Toast.LENGTH_SHORT).show()
        }
    }
    /**
     * A native method that is implemented by the 'ipp' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'ipp' library on application startup.
        init {
            System.loadLibrary("ipp")
        }
    }
}