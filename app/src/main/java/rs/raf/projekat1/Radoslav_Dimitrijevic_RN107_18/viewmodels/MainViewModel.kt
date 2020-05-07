package rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val selected : MutableLiveData<Int> = MutableLiveData()

    init {
        selected.value = 1
    }

    fun getSelected(): LiveData<Int> {
        return selected
    }

    fun setSelected(sel: Int) {
        selected.value = sel
    }
}