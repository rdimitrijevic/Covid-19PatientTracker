package rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.activities.viewpager


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.R
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.activities.fragments.listfragments.CekaonicaFragment
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.activities.fragments.listfragments.HospitalizacijaFragment
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.activities.fragments.listfragments.OtpusteniFragment

class ViewPagerAdapter(fragmentManager: FragmentManager,
                        val cekaonica_str: String,
                        val hospitalizacija_str: String,
                        val otpusteni_str: String) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        private const val ITEM_COUNT = 3
        const val FRAGMENT_1 = 0
        const val FRAGMENT_2 = 1
        const val FRAGMENT_3 = 2
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            FRAGMENT_1 -> CekaonicaFragment()
            FRAGMENT_2 -> HospitalizacijaFragment()
            else -> OtpusteniFragment()
        }
    }

    override fun getCount(): Int {
        return ITEM_COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            FRAGMENT_1 -> cekaonica_str
            FRAGMENT_2 -> hospitalizacija_str
            else -> otpusteni_str
        }
    }

}