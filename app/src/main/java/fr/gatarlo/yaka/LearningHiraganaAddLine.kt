package fr.gatarlo.yaka

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_learning_hiragana_add_line.*
import kotlin.math.E

class LearningHiraganaAddLine : AppCompatActivity() {

    private lateinit var learningHiraganaAddLineButton: Button
    lateinit var _realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learning_hiragana_add_line)
        _realm = Realm.getDefaultInstance()

        learningHiraganaAddLineButton = findViewById(R.id.learning_hiragana_create_button)
        val LearningHiraganaIntent = Intent(this, LearningHiragana::class.java)
        learningHiraganaAddLineButton.setOnClickListener {

            val A_Hiragana = addAHiragana.text.toString()
            val I_Hiragana = addIHiragana.text.toString()
            val U_Hiragana = addUHiragana.text.toString()
            val E_Hiragana = addEHiragana.text.toString()
            val O_Hiragana = addOHiragana.text.toString()

            if (A_Hiragana.isNotEmpty() && I_Hiragana.isNotEmpty()
                && U_Hiragana.isNotEmpty() && E_Hiragana.isNotEmpty()
                && O_Hiragana.isNotEmpty()) {
                val hiragana = Hiragana()

                hiragana.A_Hiragana = A_Hiragana
                hiragana.I_Hiragana = I_Hiragana
                hiragana.U_Hiragana = U_Hiragana
                hiragana.E_Hiragana = E_Hiragana
                hiragana.O_Hiragana = O_Hiragana

                _realm.beginTransaction()
                _realm.copyToRealm(hiragana)
                _realm.commitTransaction()

                addAHiragana.text.clear()
                addIHiragana.text.clear()
                addUHiragana.text.clear()
                addEHiragana.text.clear()
                addOHiragana.text.clear()
            }
        }
    }
}