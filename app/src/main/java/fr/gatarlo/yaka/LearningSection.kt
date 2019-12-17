package fr.gatarlo.yaka

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LearningSection : AppCompatActivity(){

    private lateinit var HiraganaButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learning_section)

        HiraganaButton = findViewById(R.id.learningHiraganaButton)
        val learningHiraganaIntent = Intent(this, LearningHiragana::class.java)
        HiraganaButton.setOnClickListener {
            startActivity(learningHiraganaIntent)
        }
    }

}