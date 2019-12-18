package fr.gatarlo.yaka

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.realm.Realm

class LearningHiraganaAddLine : AppCompatActivity() {

    lateinit var _realm: Realm
    val hiragana = Hiragana()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learning_hiragana_add_line)
        _realm = Realm.getDefaultInstance()



    }
}