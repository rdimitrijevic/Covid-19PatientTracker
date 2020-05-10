package rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.activities.recycleview.otpusteni

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.fragment_profil.*
import kotlinx.android.synthetic.main.holder_pacijent.*
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.R
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.datamodels.Pacijent

class PacijentOtpusteniViewHolder(
    override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    init {
        btn_left.visibility = View.GONE
        btn_right.visibility = View.GONE
    }

    fun bind(p: Pacijent) {
        holder_ime.text = p.ime
        holder_prezime.text = p.prezime
        holder_simptom.text = p.getDatumOtpusta()
    }
}