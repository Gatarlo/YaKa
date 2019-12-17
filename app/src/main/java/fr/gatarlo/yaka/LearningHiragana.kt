package fr.gatarlo.yaka

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_learning_hiragana.*

class LearningHiragana : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learning_hiragana)

        learningHiraganaRecyclorView.adapter = HiraganaAdapter()
        learningHiraganaRecyclorView.layoutManager = LinearLayoutManager(this)
    }

}