package rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.activities.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import kotlinx.android.synthetic.main.fragment_profil.*
import kotlinx.android.synthetic.main.fragment_stanje.*
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.R
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.viewmodels.MainViewModel


class StanjeFragment() : Fragment(R.layout.fragment_stanje) {
    val sharedViewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initText()
    }

    private fun initText() {
        stanje_cekaonica_broj.text = sharedViewModel.getCekaonica().value.toString()
        stanje_hospitalizovani_broj.text = sharedViewModel.getHospitalizovani().value.toString()
        stanje_otpusteni_broj.text = sharedViewModel.getOtpusteni().value.toString()
    }

}
