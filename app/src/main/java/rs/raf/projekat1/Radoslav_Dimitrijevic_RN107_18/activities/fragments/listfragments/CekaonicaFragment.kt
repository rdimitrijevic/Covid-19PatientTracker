package rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.activities.fragments.listfragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_cekaonica.*
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.R
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.activities.recycleview.cekaonica.CekaonicaAdapter
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.activities.recycleview.cekaonica.CekaonicaDiffItemCallback
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.datamodels.Pacijent
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.viewmodels.MainViewModel
import java.util.*

class CekaonicaFragment: Fragment(R.layout.fragment_cekaonica) {

    val sharedViewModel: MainViewModel by activityViewModels()

    private lateinit var cekaonicaAdapter: CekaonicaAdapter

    private val otpustiPacijenta : (Pacijent) -> Unit = {
        val datumOtpusta: String = {
            val calendar = java.util.Calendar.getInstance()
            val dateFormat = java.text.SimpleDateFormat("dd.mm.yyyy")
            dateFormat.format(calendar.time)
        }.invoke()
        it.setDatumOtpusta(datumOtpusta)

        sharedViewModel.removeCekaonica(it)
        sharedViewModel.addOtpusteni(it)
    }
    private val hospitalizujPacijenta : (Pacijent) -> Unit = {
        sharedViewModel.removeCekaonica(it)
        sharedViewModel.addHospitalizovani(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        initObservers()
    }

    private fun initRecycler() {
        cekaonica_rv.layoutManager = LinearLayoutManager(this.context)
        cekaonicaAdapter = CekaonicaAdapter(CekaonicaDiffItemCallback(), otpustiPacijenta, hospitalizujPacijenta)
        cekaonica_rv.adapter = cekaonicaAdapter
    }

    private fun initObservers() {
        sharedViewModel.getCekaonicaLive().observe(viewLifecycleOwner, Observer {
            cekaonicaAdapter.submitList(it)
        })
    }
}