package rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.viewmodels

import android.preference.PreferenceManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfilViewModel: ViewModel() {
    val ime: MutableLiveData<String> = MutableLiveData()
    val prezime: MutableLiveData<String> = MutableLiveData()
    val bolnica: MutableLiveData<String> = MutableLiveData()

    fun getIme(): LiveData<String> {
        return ime
    }

    fun setIme(_ime: String) {
        ime.value = _ime
    }

    fun getPrezime(): LiveData<String> {
        return prezime
    }

    fun setPrezime(_prezime: String) {
        prezime.value = _prezime
    }

    fun getBolnica(): LiveData<String> {
        return bolnica
    }

    fun setBolnica(_bolnica: String) {
        bolnica.value = _bolnica
    }
}