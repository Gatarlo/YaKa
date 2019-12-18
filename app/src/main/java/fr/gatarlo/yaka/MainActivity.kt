package fr.gatarlo.yaka

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var homeLearningButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        homeLearningButton = findViewById(R.id.homeLearningButton)
        val learningSectionIntent = Intent(this, LearningSection::class.java)
        homeLearningButton.setOnClickListener {
            startActivity(learningSectionIntent)
        }
    }
}
