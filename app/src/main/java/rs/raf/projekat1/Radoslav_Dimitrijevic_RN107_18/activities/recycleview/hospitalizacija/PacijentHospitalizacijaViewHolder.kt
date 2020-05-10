package rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.activities.recycleview.hospitalizacija

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.fragment_profil.*
import kotlinx.android.synthetic.main.holder_pacijent.*
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.R
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.datamodels.Pacijent

class PacijentHospitalizacijaViewHolder(
    override val containerView: View,
    onOtpust: (Int) -> Unit,
    onKarton: (Int) -> Unit ) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    init {
        btn_left.text = "OTPUST"
        btn_left.setOnClickListener{
            if(adapterPosition != RecyclerView.NO_POSITION) {
                onOtpust.invoke(adapterPosition)
            }

        }

        btn_right.text = "KARTON"
        btn_right.setOnClickListener{
            if(adapterPosition != RecyclerView.NO_POSITION) {
//                onKarton.invoke(adapterPosition)
            }
        }

        holder_simptom.visibility = View.GONE
    }

    fun bind(p: Pacijent) {
        holder_ime.text = p.ime
        holder_prezime.text = p.prezime
        holder_simptom.text = p.simptomi
    }
}