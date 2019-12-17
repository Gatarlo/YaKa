package fr.gatarlo.yaka

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.cell_hiragana.view.*

class HiraganaAdapter : RecyclerView.Adapter<HiraganaAdapter.HiraganaViewHolder>() {

    val _kanaList = arrayOf(Hiragana("あ　a", "い　i", "う　u", "え　e", "お o"),
        Hiragana("か　ka", "き　ki", "く　ku", "け　ke", "こ　ko"),
        Hiragana("さ　sa", "し　shi", "す　su", "せ　se", "そ　so"),
        Hiragana("た　ta", "ち　chi", "つ　tsu", "て　te", "と　to"),
        Hiragana("な　na", "に　ni", "ぬ　nu", "ね　ne", "の　no"),
        Hiragana("は　ha", "ひ　hi", "ふ　fu", "へ　he", "ほ　ho"),
        Hiragana("ま　ma", "み　mi", "む　mu", "め　me", "も　mo"),
        Hiragana("や　ya", "", "ゆ　yu", "", "よ　yo"),
        Hiragana("ら　ra", "り　ri", "る　ru", "れ　re", "ろ　ro"),
        Hiragana("わ　wa", "", "", "", "を　wo"),
        Hiragana("ん n", "", "", "", ""))

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