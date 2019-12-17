package fr.gatarlo.yaka

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var homeLeaningButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        homeLeaningButton = findViewById(R.id.homeLearningButton)
        val learningSectionIntent = Intent(this, LearningSection::class.java)
        homeLeaningButton.setOnClickListener {
            startActivity(learningSectionIntent)
        }
    }
}
