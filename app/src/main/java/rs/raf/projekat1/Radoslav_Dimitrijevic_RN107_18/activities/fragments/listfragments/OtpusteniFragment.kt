package rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.activities.fragments.listfragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_hospitalizacija.*
import kotlinx.android.synthetic.main.fragment_otpusteni.*
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.R
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.activities.recycleview.otpusteni.OtpusteniAdapter
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.activities.recycleview.otpusteni.OtpusteniDiffItemCallback
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.viewmodels.MainViewModel

class OtpusteniFragment: Fragment(R.layout.fragment_otpusteni) {
    private val sharedViewModel: MainViewModel by activityViewModels()

    private lateinit var otpusteniAdapter: OtpusteniAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        initObservers()
    }

    private fun initRecycler() {
        otpusteni_rv.layoutManager = GridLayoutManager(this.context, 2)
        otpusteniAdapter = OtpusteniAdapter(OtpusteniDiffItemCallback())
        otpusteni_rv.adapter = otpusteniAdapter
    }

    private fun initObservers() {
        sharedViewModel.getOtpusteniLive().observe(viewLifecycleOwner, Observer {
            otpusteniAdapter.submitList(it)
        })
    }

}