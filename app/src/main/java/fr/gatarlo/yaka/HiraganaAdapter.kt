package fr.gatarlo.yaka

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.cell_hiragana.view.*

class HiraganaAdapter : RecyclerView.Adapter<HiraganaAdapter.HiraganaViewHolder>() {

    val _kanaList = arrayOf(Hiragana("あ", "a"),
        Hiragana("い", "i"), Hiragana("う ", "u"),
        Hiragana("え", "e"), Hiragana("お", "o"),
        Hiragana("か ", "ka"),
        Hiragana("き", "ki"), Hiragana("く ", "ku"),
        Hiragana("け", "ke"), Hiragana("こ", "ko"),
        Hiragana("さ", "sa"),
        Hiragana("し", "shi"), Hiragana("す ", "su"),
        Hiragana("せ", "se"), Hiragana("そ", "so")
    )

    class  HiraganaViewHolder(rootView: View) : RecyclerView.ViewHolder(rootView) {
        val learningHiraganaKanaDisplay = rootView.learningHiraganaKanaDisplay
        val learningHiraganaTraductionDisplay = rootView.learningHiraganaTraductionDisplay

        fun fillWithHiragana (hiragana: Hiragana) {
            learningHiraganaKanaDisplay.text = hiragana.kana
            learningHiraganaTraductionDisplay.text = hiragana.pronunciation
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