package rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.activities.recycleview.hospitalizacija

import androidx.recyclerview.widget.DiffUtil
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.datamodels.Pacijent

class HospitalizacijaDiffItemCallback : DiffUtil.ItemCallback<Pacijent>() {

    override fun areItemsTheSame(oldItem: Pacijent, newItem: Pacijent): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Pacijent, newItem: Pacijent): Boolean {
        return oldItem.ime == newItem.ime &&
                oldItem.prezime == newItem.prezime
    }


}