package rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.activities

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.R
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.activities.fragments.ListFragment
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.activities.fragments.ProfilFragment
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.activities.fragments.StanjeFragment
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.viewmodels.MainViewModel
import timber.log.Timber

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val mainViewModel: MainViewModel by viewModels()

    companion object {
        val PROFILE_CHANGE: Int = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        initRadnik()
        initObserver()
        initSelection(mainViewModel.getSelected().value ?: 1, 0)
        initListeners()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


        if( requestCode == PROFILE_CHANGE) {

            if ( resultCode != Activity.RESULT_OK) return

            val sp = getSharedPreferences(packageName, Context.MODE_PRIVATE)

            Timber.e(sp.getString(LoginActivity.IME, mainViewModel.getIme().value.toString()))
            Timber.e(sp.getString(LoginActivity.PREZIME, mainViewModel.getPrezime().value.toString()))
            Timber.e(sp.getString(LoginActivity.IME_BOLNICE, mainViewModel.getBolnica().value.toString()))

            mainViewModel.setIme(sp.getString(LoginActivity.IME, mainViewModel.getIme().value.toString()) ?: "null")
            mainViewModel.setPrezime(sp.getString(LoginActivity.PREZIME, mainViewModel.getPrezime().value.toString()) ?: "null")
            mainViewModel.setBolnica(sp.getString(LoginActivity.IME_BOLNICE, mainViewModel.getBolnica().value.toString()) ?: "null")
        }

    }

    private fun initObserver() {
        mainViewModel.getLogout().observe(this, Observer {
            if ( it ) logout()
        })
    }

    private fun initRadnik() {
        val sp = getSharedPreferences(packageName, Context.MODE_PRIVATE)

        mainViewModel.setIme(sp.getString(LoginActivity.IME, "NULL") ?: "Null")
        mainViewModel.setPrezime(sp.getString(LoginActivity.PREZIME, "NULL") ?: "Null")
        mainViewModel.setBolnica(sp.getString(LoginActivity.IME_BOLNICE, "NULL") ?: "Null")
    }

    private fun initSelection(sel: Int, prev_sel: Int) {
        main_btn_stanje.isChecked = if (sel == 1) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_fragment, StanjeFragment())
            transaction.commit()
            true
        }
        else{
            false
        }

        main_btn_unos.isChecked = sel == 2

        main_btn_liste.isChecked = if (sel == 3) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_fragment, ListFragment())
            transaction.commit()
            true
        }
        else{
            false
        }

        main_btn_profil.isChecked = if (sel == 4) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_fragment, ProfilFragment())
            transaction.commit()
            true
        }
        else{
            false
        }
    }

    private fun initListeners() {
        initToolbarListeners()
    }

    private fun initToolbarListeners() {

        main_btn_stanje.setOnClickListener {
            val sel = mainViewModel.getSelected().value ?: 0
            mainViewModel.setSelected(1)
            initSelection(1, sel)

        }

        main_btn_unos.setOnClickListener {
            val sel = mainViewModel.getSelected().value ?: 0
            mainViewModel.setSelected(2)
            initSelection(2, sel)
        }

        main_btn_liste.setOnClickListener {
            val sel = mainViewModel.getSelected().value ?: 0
            mainViewModel.setSelected(3)
            initSelection(3, sel)
        }

        main_btn_profil.setOnClickListener {
            val sel = mainViewModel.getSelected().value ?: 0
            mainViewModel.setSelected(4)
            initSelection(4, sel)
        }
    }

    private fun logout() {
        val sp = getSharedPreferences(packageName, Context.MODE_PRIVATE)
        val editor = sp.edit()

        editor.putString(LoginActivity.IME, "")
        editor.putString(LoginActivity.PREZIME, "")
        editor.putString(LoginActivity.IME_BOLNICE, "")
        editor.commit()

        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()

    }
}
