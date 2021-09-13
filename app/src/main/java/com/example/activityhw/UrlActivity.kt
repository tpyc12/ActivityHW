package com.example.activityhw

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class UrlActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_url)

        textView = findViewById(R.id.tvMessage)
        textView.text = "URL Activity"

        val buttonMainActivity: Button = findViewById(R.id.buttonMain)
        val buttonSecondActivity: Button = findViewById(R.id.buttonSecond)
        val buttonThirdActivity: Button = findViewById(R.id.buttonThird)

        buttonMainActivity.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        buttonSecondActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        buttonThirdActivity.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java )
            count++
            intent.putExtra(EXTRAS_KEY_COUNT, count)
            startActivity(intent)
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        textView.text = "ThirdActivity click $count counts"
    }

    companion object{
        const val EXTRAS_KEY_COUNT = "EXTRAS_KEY_COUNT"
    }
}