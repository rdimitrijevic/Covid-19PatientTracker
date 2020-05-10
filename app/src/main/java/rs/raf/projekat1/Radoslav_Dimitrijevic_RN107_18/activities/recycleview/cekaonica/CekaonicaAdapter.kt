package rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.activities.recycleview.cekaonica

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.R
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.datamodels.Pacijent

class CekaonicaAdapter (
    carDiffItemCallback: CekaonicaDiffItemCallback,
    private val onOtpust: (Pacijent) -> Unit,
    private val onHosp: (Pacijent) -> Unit) : ListAdapter<Pacijent, PacijentCekaonicaViewHolder>(carDiffItemCallback) {

    private val onOtpust2: (Int) -> Unit = {
        val p = getItem(it)
        onOtpust.invoke(p)
    }

    private val onHosp2: (Int) -> Unit = {
        val p = getItem(it)
        onHosp.invoke(p)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PacijentCekaonicaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.holder_pacijent, parent, false)
        return PacijentCekaonicaViewHolder(containerView, onOtpust2, onHosp2)
    }

    override fun onBindViewHolder(holder: PacijentCekaonicaViewHolder, position: Int) {
        val p = getItem(position)
        holder.bind(p)
    }

}