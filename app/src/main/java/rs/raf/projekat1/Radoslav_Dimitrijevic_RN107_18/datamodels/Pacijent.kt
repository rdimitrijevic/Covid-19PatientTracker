package rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.datamodels

import android.annotation.SuppressLint


data class Pacijent(val id: Int, val ime: String, val prezime: String, val simptomi: String) {
    @SuppressLint("SimpleDateFormat")
    val datumPrijema: String = {
        val calendar = java.util.Calendar.getInstance()
        val dateFormat = java.text.SimpleDateFormat("dd.mm.yyyy")
        dateFormat.format(calendar.time)
    }.invoke()

    private var trenutniSimptomi: String = ""
    private var datumOtpusta: String = ""
    private var hospitalizovan: Boolean? = null

    fun getTrenutniSimptomi(): String {
        return trenutniSimptomi
    }

    fun setTrenutniSimptomi(s: String) {
        trenutniSimptomi = s
    }

    fun getDatumOtpusta(): String {
        return datumOtpusta
    }

    fun setDatumOtpusta(d: String) {
        datumOtpusta = d
    }

    fun getHospitalizovan(): Boolean? {
        return hospitalizovan
    }

    fun setHospitalizovan(s: Boolean) {
        hospitalizovan = s
    }
}