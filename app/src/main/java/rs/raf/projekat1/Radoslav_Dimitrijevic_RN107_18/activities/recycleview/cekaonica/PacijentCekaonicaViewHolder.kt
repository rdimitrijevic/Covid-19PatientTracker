package rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.activities.recycleview.cekaonica

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.fragment_profil.*
import kotlinx.android.synthetic.main.holder_pacijent.*
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.R
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.datamodels.Pacijent

class PacijentCekaonicaViewHolder(
    override val containerView: View,
    onOtpust: (Int) -> Unit,
    onHosp: (Int) -> Unit ) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    init {
/*
        holder_simptom.visibility = View.VISIBLE
        btn_right.visibility = View.VISIBLE
        btn_left.visibility = View.VISIBLE
*/

        btn_left.text = "ZDRAV"
        btn_left.setOnClickListener{
            if(adapterPosition != RecyclerView.NO_POSITION) {
                onOtpust.invoke(adapterPosition)
            }

        }

        btn_right.text = "HOSPITALIZACIJA"
        btn_right.setOnClickListener{
            if(adapterPosition != RecyclerView.NO_POSITION) {
                onHosp.invoke(adapterPosition)
            }
        }

    }

    fun bind(p: Pacijent) {
        holder_ime.text = p.ime
        holder_prezime.text = p.prezime
        holder_simptom.text = p.simptomi
    }
}