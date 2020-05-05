package rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {
    private var ime: MutableLiveData<String> = MutableLiveData()
    private var prezime: MutableLiveData<String> = MutableLiveData()
    private var imeBolnice: MutableLiveData<String> = MutableLiveData()
    private var pin: MutableLiveData<String> = MutableLiveData()

    init {
        ime.value = ""
        prezime.value = ""
        imeBolnice.value = ""
        pin.value = ""
    }

    fun getIme(): LiveData<String>{
        return ime
    }

    fun setIme(imeText: String){
        ime.value = imeText
    }

    fun getPrezime(): LiveData<String>{
        return prezime
    }

    fun setPrezime(prezimeText: String): Unit {
        prezime.value = prezimeText
    }

    fun getImeBolnice(): LiveData<String>{
        return imeBolnice
    }

    fun setImeBolnice(imeBolniceText: String): Unit {
        imeBolnice.value = imeBolniceText
    }

    fun getPin(): LiveData<String>{
        return pin
    }

    fun setPin(pinText: String): Unit {
        pin.value = pinText
    }

}
