package fr.gatarlo.yaka

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_learning_hiragana_edit_line.*
import kotlinx.android.synthetic.main.cell_hiragana.*
import kotlin.math.E

class LearningHiraganaEditLine : AppCompatActivity() {

    lateinit var _realm: Realm
    lateinit var selectedLine:Hiragana


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learning_hiragana_edit_line)
        _realm = Realm.getDefaultInstance()

        val HiraganaA = getIntent().getStringExtra("A_Hiragana")
        val HiraganaI = getIntent().getStringExtra("I_Hiragana")
        val HiraganaU = getIntent().getStringExtra("U_Hiragana")
        val HiraganaE = getIntent().getStringExtra("E_Hiragana")
        val HiraganaO = getIntent().getStringExtra("O_Hiragana")

        selectedLine = _realm.where(Hiragana::class.java).equalTo("A_Hiragana",HiraganaA).equalTo("I_Hiragana", HiraganaI).equalTo("U_Hiragana", HiraganaU)
            .equalTo("E_Hiragana", HiraganaE).equalTo("O_Hiragana", HiraganaO).findFirst()!!

        actual_kana_A.text = "${HiraganaA}"
        actual_kana_I.text = "${HiraganaI}"
        actual_kana_U.text = "${HiraganaU}"
        actual_kana_E.text = "${HiraganaE}"
        actual_kana_O.text = "${HiraganaO}"
    }

    fun editHiragana(button: View) {
        _realm.beginTransaction()

        selectedLine.A_Hiragana = edit_kana_A.text.toString()
        selectedLine.I_Hiragana = edit_kana_I.text.toString()
        selectedLine.U_Hiragana = edit_kana_U.text.toString()
        selectedLine.E_Hiragana = edit_kana_E.text.toString()
        selectedLine.O_Hiragana = edit_kana_O.text.toString()

        _realm.commitTransaction()
        val intent = Intent(this, LearningHiragana::class.java)

        edit_kana_A.text.clear()
        edit_kana_I.text.clear()
        edit_kana_U.text.clear()
        edit_kana_E.text.clear()
        edit_kana_O.text.clear()

        startActivity(intent)
    }

    fun deleteLine(button: View){
        _realm.beginTransaction()

        selectedLine.deleteFromRealm()

        _realm.commitTransaction()
        val intent = Intent(this, LearningHiragana::class.java)

        startActivity(intent)
    }
}