package rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.activities.recycleview.hospitalizacija

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.R
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.datamodels.Pacijent

class HospitalizacijaAdapter (
    carDiffItemCallback: HospitalizacijaDiffItemCallback,
    private val onOtpust: (Pacijent) -> Unit,
    private val onKarton: (Pacijent) -> Unit) : ListAdapter<Pacijent, PacijentHospitalizacijaViewHolder>(carDiffItemCallback) {

    private val onOtpust2: (Int) -> Unit = {
        val p = getItem(it)
        onOtpust.invoke(p)
    }

    private val onKarton2: (Int) -> Unit = {
 /*       val p = getItem(it)
        onKarton.invoke(p)*/
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PacijentHospitalizacijaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.holder_pacijent, parent, false)
        return PacijentHospitalizacijaViewHolder(containerView, onOtpust2, onKarton2)
    }

    override fun onBindViewHolder(holder: PacijentHospitalizacijaViewHolder, position: Int) {
        val p = getItem(position)
        holder.bind(p)
    }

}