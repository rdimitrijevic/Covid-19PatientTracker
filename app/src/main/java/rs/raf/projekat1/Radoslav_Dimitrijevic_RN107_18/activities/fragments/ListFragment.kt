package rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.activities.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import kotlinx.android.synthetic.main.fragment_list.*
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.R
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.activities.viewpager.ViewPagerAdapter
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.viewmodels.MainViewModel

class ListFragment: Fragment(R.layout.fragment_list) {
    val sharedViewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        val cekaonica = getString(R.string.cekaonica)
        val hospitalizacija = getString(R.string.hospitalizacija)
        val otpusteni = getString(R.string.otpusteni)
        pager.adapter = ViewPagerAdapter(childFragmentManager, cekaonica,hospitalizacija,otpusteni)
        tabs.setupWithViewPager(pager)
    }

}