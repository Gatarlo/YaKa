package fr.gatarlo.yaka

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_learning_hiragana.*
import kotlinx.android.synthetic.main.cell_hiragana.view.*

class LearningHiragana : AppCompatActivity() {

    private lateinit var learningHiraganaAddLineButton: Button
/*    private lateinit var learningHiraganaAHiraganaDetailsButton: Button
    private lateinit var learningHiraganaIHiraganaDetailsButton: Button
    private lateinit var learningHiraganaUHiraganaDetailsButton: Button
    private lateinit var learningHiraganaEHiraganaDetailsButton: Button
    private lateinit var learningHiraganaOHiraganaDetailsButton: Button*/

    lateinit var _realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learning_hiragana)

        _realm = Realm.getDefaultInstance()
        learningHiraganaRecyclorView.adapter = HiraganaAdapter()
        learningHiraganaRecyclorView.layoutManager = LinearLayoutManager(this)

        learningHiraganaAddLineButton = findViewById(R.id.addHiraganaLine)
        val learningHiraganaAddLineIntent = Intent(this, LearningHiraganaAddLine::class.java)
        learningHiraganaAddLineButton.setOnClickListener {
            startActivity(learningHiraganaAddLineIntent)
        }

        /*learningHiraganaAHiraganaDetailsButton = findViewById(R.id.A_Hiragana)
        val learningHiraganaAHiraganaDetailsIntent =
            Intent(this, LearningKanaDetails::class.java)
        learningHiraganaAHiraganaDetailsButton.setOnClickListener {
            startActivity(learningHiraganaAHiraganaDetailsIntent)
        }

        learningHiraganaIHiraganaDetailsButton = findViewById(R.id.I_Hiragana)
        val learningHiraganaIHiraganaDetailsIntent =
            Intent(this, LearningKanaDetails::class.java)
        learningHiraganaIHiraganaDetailsButton.setOnClickListener {
            startActivity(learningHiraganaIHiraganaDetailsIntent)
        }

        learningHiraganaUHiraganaDetailsButton = findViewById(R.id.U_Hiragana)
        val learningHiraganaUHiraganaDetailsIntent =
            Intent(this, LearningKanaDetails::class.java)
        learningHiraganaUHiraganaDetailsButton.setOnClickListener {
            startActivity(learningHiraganaUHiraganaDetailsIntent)
        }

        learningHiraganaEHiraganaDetailsButton = findViewById(R.id.E_Hiragana)
        val learningHiraganaEHiraganaDetailsIntent =
            Intent(this, LearningKanaDetails::class.java)
        learningHiraganaEHiraganaDetailsButton.setOnClickListener {
            startActivity(learningHiraganaEHiraganaDetailsIntent)
        }

        learningHiraganaOHiraganaDetailsButton = findViewById(R.id.O_Hiragana)
        val learningHiraganaOHiraganaDetailsIntent =
            Intent(this, LearningKanaDetails::class.java)
        learningHiraganaOHiraganaDetailsButton.setOnClickListener {
            startActivity(learningHiraganaOHiraganaDetailsIntent)
        }*/
    }


    inner class HiraganaAdapter : RecyclerView.Adapter<HiraganaAdapter.HiraganaViewHolder>() {

        val _kanaList = _realm.where(Hiragana::class.java).findAll()

        fun onLineClick(kanaIndex:Int) {
            val hiragana = _kanaList[kanaIndex]
            transfertKana(hiragana!!)
        }

        inner class HiraganaViewHolder(rootView: View) : RecyclerView.ViewHolder(rootView), View.OnClickListener {
            val learningHiraganaAKanaDisplay = rootView.A_Hiragana
            val learningHiraganaIKanaDisplay = rootView.I_Hiragana
            val learningHiraganaUKanaDisplay = rootView.U_Hiragana
            val learningHiraganaEKanaDisplay = rootView.E_Hiragana
            val learningHiraganaOKanaDisplay = rootView.O_Hiragana

            init {
                rootView.setOnClickListener { onLineClick(adapterPosition) }
            }

            fun fillWithHiragana (hiragana: Hiragana) {
                learningHiraganaAKanaDisplay.text = hiragana.A_Hiragana
                learningHiraganaIKanaDisplay.text = hiragana.I_Hiragana
                learningHiraganaUKanaDisplay.text = hiragana.U_Hiragana
                learningHiraganaEKanaDisplay.text = hiragana.E_Hiragana
                learningHiraganaOKanaDisplay.text = hiragana.O_Hiragana
            }

            override fun onClick(p0: View?) {
                if (p0 != null) {
                    onLineClick(adapterPosition)
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HiraganaViewHolder {
            // 1 — Charger la vue en XML
            val rootView = LayoutInflater.from(parent.context).inflate(R.layout.cell_hiragana, parent, false)

            // 2 — Créer un viewholder pour contrôler cette vue
            val holder = HiraganaViewHolder(rootView)

            // 3 — retourner le viewholder
            return holder
        }

        override fun getItemCount(): Int {
            return _kanaList.size
        }

        override fun onBindViewHolder(holder: HiraganaViewHolder, position: Int) {
            // 1 — Obtenir le kana
            val hiragana = _kanaList[position]

            // 2 — Envoyer les infos du kana dans le holder
            holder.fillWithHiragana(_kanaList[position]!!)

        }
    }

    fun transfertKana (Hiragana: Hiragana){
        val hiraganaIntent = Intent(this@LearningHiragana, LearningHiraganaEditLine::class.java)
        hiraganaIntent.putExtra("A_Hiragana", Hiragana.A_Hiragana)
        hiraganaIntent.putExtra("I_Hiragana", Hiragana.I_Hiragana)
        hiraganaIntent.putExtra("U_Hiragana", Hiragana.U_Hiragana)
        hiraganaIntent.putExtra("E_Hiragana", Hiragana.E_Hiragana)
        hiraganaIntent.putExtra("O_Hiragana", Hiragana.O_Hiragana)
        startActivity(hiraganaIntent)
    }
}