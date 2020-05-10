package rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.activities.fragments.listfragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_cekaonica.*
import kotlinx.android.synthetic.main.fragment_hospitalizacija.*
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.R
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.activities.recycleview.hospitalizacija.HospitalizacijaAdapter
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.activities.recycleview.hospitalizacija.HospitalizacijaDiffItemCallback
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.datamodels.Pacijent
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.viewmodels.MainViewModel

class HospitalizacijaFragment: Fragment(R.layout.fragment_hospitalizacija) {
    val sharedViewModel: MainViewModel by activityViewModels()

    private lateinit var hospitalizacijaAdapter: HospitalizacijaAdapter

    private val otpustiPacijenta : (Pacijent) -> Unit = {
        val datumOtpusta: String = {
            val calendar = java.util.Calendar.getInstance()
            val dateFormat = java.text.SimpleDateFormat("dd.mm.yyyy")
            dateFormat.format(calendar.time)
        }.invoke()
        it.setDatumOtpusta(datumOtpusta)

        sharedViewModel.removeHospitalizovani(it)
        sharedViewModel.addOtpusteni(it)
    }
    private val hospitalizujPacijenta : (Pacijent) -> Unit = {
/*
        sharedViewModel.removeCekaonica(it)
        sharedViewModel.addHospitalizovani(it)
*/
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        initObservers()
    }

    private fun initRecycler() {
        hospitalizacija_rv.layoutManager = LinearLayoutManager(this.context)
        hospitalizacijaAdapter = HospitalizacijaAdapter(HospitalizacijaDiffItemCallback(), otpustiPacijenta, hospitalizujPacijenta)
        hospitalizacija_rv.adapter = hospitalizacijaAdapter
    }

    private fun initObservers() {
        sharedViewModel.getHospitalizovaniLive().observe(viewLifecycleOwner, Observer {
            hospitalizacijaAdapter.submitList(it)
        })
    }

}