package rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.datamodels.Pacijent

class MainViewModel: ViewModel() {
    private val selectedFrag : MutableLiveData<Int> = MutableLiveData()

    private val shouldLogout: MutableLiveData<Boolean> = MutableLiveData()

    private val cekaonica: MutableLiveData<Int> = MutableLiveData()
    private val hospitalizovani: MutableLiveData<Int> = MutableLiveData()
    private val otpusteni: MutableLiveData<Int> = MutableLiveData()

    private var lastId: Int = 14

    private var ime: MutableLiveData<String> = MutableLiveData()
    private var prezime: MutableLiveData<String> = MutableLiveData()
    private var bolnica: MutableLiveData<String> = MutableLiveData()

    private val cekaonicaList: MutableList<Pacijent> = mutableListOf<Pacijent>()
    private val hospitalizovaniList: MutableList<Pacijent> = mutableListOf<Pacijent>()
    private val otpusteniList: MutableList<Pacijent> = mutableListOf<Pacijent>()

    private val cekaonicaLiveList: MutableLiveData<List<Pacijent>> = {

        for (i in 1..15) {
            if (cekaonica.value == null) cekaonica.value = 1 else cekaonica.value = cekaonica.value?.plus(1)
            val pacijent = Pacijent(i, "Petar" + i.toString(), "Petrovic", "Kasalj i temperatura")
            cekaonicaList.add(pacijent)
        }

        val l = MutableLiveData<List<Pacijent>>()
        l.value = cekaonicaList
        l
    }.invoke()
    private val hospitalizovaniLiveList: MutableLiveData<List<Pacijent>> = MutableLiveData()

    private val otpusteniLiveList: MutableLiveData<List<Pacijent>> = MutableLiveData()

    init {
        selectedFrag.value = 1
        shouldLogout.value = false
        hospitalizovani.value = 0
        otpusteni.value = 0
    }

    fun getSelected(): LiveData<Int> {
        return selectedFrag
    }

    fun setSelected(sel: Int) {
        selectedFrag.value = sel
    }

    fun getCekaonica(): LiveData<Int> {
        return cekaonica
    }

    fun getHospitalizovani(): LiveData<Int> {
        return hospitalizovani
    }

    fun getOtpusteni(): LiveData<Int> {
        return otpusteni
    }

    fun getIme(): LiveData<String> {
        return ime
    }

    fun getPrezime(): LiveData<String> {
        return prezime
    }

    fun getBolnica(): LiveData<String> {
        return bolnica
    }

    fun setIme(_ime: String) {
        ime.value = _ime
    }

    fun setPrezime(_prezime: String) {
        prezime.value = _prezime
    }

    fun setBolnica(_bolnica: String) {
        bolnica.value = _bolnica
    }

    fun getLogout(): LiveData<Boolean> {
        return shouldLogout
    }

    fun setLogout(logout: Boolean) {
        shouldLogout.value = logout
    }

    fun getCekaonicaLive() : LiveData<List<Pacijent>> {
        return cekaonicaLiveList
    }
    fun getHospitalizovaniLive() : LiveData<List<Pacijent>> {
        return hospitalizovaniLiveList
    }
    fun getOtpusteniLive() : LiveData<List<Pacijent>> {
        return otpusteniLiveList
    }

    fun getCekaonicaList(): MutableList<Pacijent> {
        return cekaonicaList
    }
    fun getHospitalizovaniList(): MutableList<Pacijent> {
        return hospitalizovaniList
    }
    fun getOtpusteniList(): MutableList<Pacijent> {
        return otpusteniList
    }

    fun addCekaonica(p : Pacijent) {
        cekaonicaList.add(p)
        val listToSubmit = mutableListOf<Pacijent>()
        listToSubmit.addAll(cekaonicaList)
        cekaonicaLiveList.value = listToSubmit
        cekaonica.value = cekaonica.value?.plus(1)
    }

    /*
    fun removeRecoveredPatient(patient: Pacijent) {
        releasedPatientsList.remove(patient)
        val listToSubmit = mutableListOf<Pacijent>()
        listToSubmit.addAll(releasedPatientsList)
        releasedPatients.value = listToSubmit
    }
*/
    fun addHospitalizovani(patient : Pacijent) {
        hospitalizovaniList.add(patient)
        val listToSubmit = mutableListOf<Pacijent>()
        listToSubmit.addAll(hospitalizovaniList)
        hospitalizovani.value = hospitalizovani.value?.plus(1)
        hospitalizovaniLiveList.value = listToSubmit
    }
    fun addOtpusteni(patient : Pacijent) {
        otpusteniList.add(patient)
        val listToSubmit = mutableListOf<Pacijent>()
        listToSubmit.addAll(otpusteniList)
        otpusteni.value = otpusteni.value?.plus(1)
        otpusteniLiveList.value = listToSubmit
    }

    fun removeHospitalizovani(patient: Pacijent) {
        hospitalizovaniList.remove(patient)
        val listToSubmit = mutableListOf<Pacijent>()
        listToSubmit.addAll(hospitalizovaniList)
        hospitalizovaniLiveList.value = listToSubmit
        hospitalizovani.value = if (hospitalizovani.value?.minus(1) ?: 0  <= 0) 0 else hospitalizovani.value?.minus(1)
    }

    fun removeCekaonica(patient: Pacijent) {
        cekaonicaList.remove(patient)
        val listToSubmit = mutableListOf<Pacijent>()
        listToSubmit.addAll(cekaonicaList)
        cekaonica.value = if (cekaonica.value?.minus(1) ?: 0  <= 0) 0 else cekaonica.value?.minus(1)
        cekaonicaLiveList.value = listToSubmit
    }

}
