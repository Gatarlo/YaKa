package fr.gatarlo.yaka

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.cell_hiragana.view.*

class HiraganaAdapter : RecyclerView.Adapter<HiraganaAdapter.HiraganaViewHolder>() {

    val _kanaList = arrayOf(Hiragana("あ\na", "い\ni", "う\nu", "え\ne", "お\no"),
        Hiragana("か\nka", "き\nki", "く\nku", "け\nke", "こ\nko"),
        Hiragana("さ\nsa", "し\nshi", "す\nsu", "せ\nse", "そ\nso"),
        Hiragana("た\nta", "ち\nchi", "つ\ntsu", "て\nte", "と\nto"),
        Hiragana("な\nna", "に\nni", "ぬ\nnu", "ね\nne", "の\nno"),
        Hiragana("は\nha", "ひ\nhi", "ふ\nfu", "へ\nhe", "ほ\nho"),
        Hiragana("ま\nma", "み\nmi", "む\nmu", "め\nme", "も\nmo"),
        Hiragana("や\nya", "", "ゆ\nyu", "", "よ\nyo"),
        Hiragana("ら\nra", "り\n　ri", "る\nru", "れ\nre", "ろ\nro"),
        Hiragana("わ\nwa", "", "", "", "を\nwo"),
        Hiragana("ん\nn", "", "", "", ""))

    class  HiraganaViewHolder(rootView: View) : RecyclerView.ViewHolder(rootView) {
        val learningHiraganaAKanaDisplay = rootView.A_Hiragana
        val learningHiraganaIKanaDisplay = rootView.I_Hiragana
        val learningHiraganaUKanaDisplay = rootView.U_Hiragana
        val learningHiraganaEKanaDisplay = rootView.E_Hiragana
        val learningHiraganaOKanaDisplay = rootView.O_Hiragana

        fun fillWithHiragana (hiragana: Hiragana) {
            learningHiraganaAKanaDisplay.text = hiragana.A_Hiragana
            learningHiraganaIKanaDisplay.text = hiragana.I_Hiragana
            learningHiraganaUKanaDisplay.text = hiragana.U_Hiragana
            learningHiraganaEKanaDisplay.text = hiragana.E_Hiragana
            learningHiraganaOKanaDisplay.text = hiragana.O_Hiragana
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
        holder.fillWithHiragana(hiragana)

    }
}