package rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.activities.recycleview.otpusteni

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.R
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.datamodels.Pacijent

class OtpusteniAdapter (
    carDiffItemCallback: OtpusteniDiffItemCallback) : ListAdapter<Pacijent, PacijentOtpusteniViewHolder>(carDiffItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PacijentOtpusteniViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.holder_pacijent, parent, false)
        return PacijentOtpusteniViewHolder(containerView)
    }

    override fun onBindViewHolder(holder: PacijentOtpusteniViewHolder, position: Int) {
        val p = getItem(position)
        holder.bind(p)
    }

}