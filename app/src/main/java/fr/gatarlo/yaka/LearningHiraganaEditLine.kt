package fr.gatarlo.yaka

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_learning_hiragana_edit_line.*

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

        selectedLine = _realm.where(Hiragana::class.java).equalTo(
            "A_Hiragana",
            HiraganaA
        ).equalTo("I_Hiragana", HiraganaI).equalTo("U_Hiragana", HiraganaU)
            .equalTo("E_Hiragana", HiraganaE).equalTo("O_Hiragana", HiraganaO).findFirst()!!

        learningHiraganaEditActualAKana.text = "${HiraganaA}"
        learningHiraganaEditActualIKana.text = "${HiraganaI}"
        learningHiraganaEditActualUKana.text = "${HiraganaU}"
        learningHiraganaEditActualEKana.text = "${HiraganaE}"
        learningHiraganaEditActualOKana.text = "${HiraganaO}"

        learningHiraganaEditAKana.setText(selectedLine.A_Hiragana)
        learningHiraganaEditIKana.setText(selectedLine.I_Hiragana)
        learningHiraganaEditUKana.setText(selectedLine.U_Hiragana)
        learningHiraganaEditEKana.setText(selectedLine.E_Hiragana)
        learningHiraganaEditOKana.setText(selectedLine.O_Hiragana)
    }

    fun editHiragana(button: View) {
        _realm.beginTransaction()

        selectedLine.A_Hiragana = learningHiraganaEditAKana.text.toString()
        selectedLine.I_Hiragana = learningHiraganaEditIKana.text.toString()
        selectedLine.U_Hiragana = learningHiraganaEditUKana.text.toString()
        selectedLine.E_Hiragana = learningHiraganaEditEKana.text.toString()
        selectedLine.O_Hiragana = learningHiraganaEditOKana.text.toString()

        _realm.commitTransaction()
        val intent = Intent(this, LearningHiragana::class.java)

        learningHiraganaEditAKana.text.clear()
        learningHiraganaEditIKana.text.clear()
        learningHiraganaEditUKana.text.clear()
        learningHiraganaEditEKana.text.clear()
        learningHiraganaEditOKana.text.clear()

        startActivity(intent)
    }

    fun deleteLine(button: View) {
        _realm.beginTransaction()

        selectedLine.deleteFromRealm()

        _realm.commitTransaction()
        val intent = Intent(this, LearningHiragana::class.java)

        startActivity(intent)
    }
}
