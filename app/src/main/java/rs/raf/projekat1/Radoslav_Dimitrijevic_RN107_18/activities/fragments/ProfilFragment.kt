package rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.activities.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_profil.*
import kotlinx.android.synthetic.main.fragment_stanje.*
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.R
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.activities.MainActivity
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.viewmodels.MainViewModel
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.viewmodels.ProfilViewModel
import rs.raf.vezbe8.IzmeniProfilActivity

class ProfilFragment: Fragment(R.layout.fragment_profil) {
    private val sharedViewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initText()
        initObservers()
        initBtn()
    }

    private fun initText() {
        ime_data.text = sharedViewModel.getIme().value.toString()
        prezime_data.text = sharedViewModel.getPrezime().value.toString()
        bolnica_data.text = sharedViewModel.getBolnica().value.toString()
    }

    private fun initObservers() {
        sharedViewModel.getIme().observe(viewLifecycleOwner, Observer {
            ime_data.text = it
        })
        sharedViewModel.getPrezime().observe(viewLifecycleOwner, Observer {
            prezime_data.text = it
        })
        sharedViewModel.getBolnica().observe(viewLifecycleOwner, Observer {
            bolnica_data.text = it
        })
    }

    private fun initBtn() {
        btn_logout.setOnClickListener {
            sharedViewModel.setLogout(true)
        }

        btn_izmeni.setOnClickListener {
            val intent = Intent(activity, IzmeniProfilActivity::class.java)
            activity?.startActivityForResult(
                intent,
                MainActivity.PROFILE_CHANGE
            )
        }
    }
}