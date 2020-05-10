package rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class IzmeniProfilViewModel: ViewModel() {
    val izmeniIme: MutableLiveData<String> = MutableLiveData()
    val izmeniPrezime: MutableLiveData<String> = MutableLiveData()
    val izmeniBolnicu: MutableLiveData<String> = MutableLiveData()

    fun getIme(): LiveData<String> {
        return izmeniIme
    }

    fun setIme(ime: String) {
        izmeniIme.value = ime
    }

    fun getPrezime(): LiveData<String> {
        return izmeniPrezime
    }

    fun setPrezime(prezime: String) {
        izmeniPrezime.value = prezime
    }

    fun getBolnica(): LiveData<String> {
        return izmeniBolnicu
    }

    fun setBolnica(bolnica: String) {
        izmeniBolnicu.value = bolnica
    }
}