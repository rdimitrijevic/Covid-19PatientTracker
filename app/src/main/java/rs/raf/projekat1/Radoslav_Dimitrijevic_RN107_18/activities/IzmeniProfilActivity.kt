package rs.raf.vezbe8

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import kotlinx.android.synthetic.main.activity_profil.*
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.R
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.activities.LoginActivity
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.viewmodels.IzmeniProfilViewModel


class IzmeniProfilActivity : AppCompatActivity(R.layout.activity_profil) {
    private val viewModel: IzmeniProfilViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        initBtnListeners()
        initETListeners()
    }

    private fun initETListeners() {
        tf_profil_ime.doAfterTextChanged {
            viewModel.setIme(it.toString())
        }
        tf_profil_prezime.doAfterTextChanged {
            viewModel.setPrezime(it.toString())
        }
        tf_profil_bolnica.doAfterTextChanged {
            viewModel.setBolnica(it.toString())
        }
    }

    private fun initBtnListeners() {
        btn_change.setOnClickListener {
            val ime = viewModel.getIme().value
            val prezime = viewModel.getPrezime().value
            val bolnica = viewModel.getBolnica().value

            if( ime.isNullOrEmpty() && prezime.isNullOrEmpty() && bolnica.isNullOrEmpty()) {
                Toast
                    .makeText(this, "At least one field must bi filled in", Toast.LENGTH_LONG)
                    .show()
                return@setOnClickListener
            }

            val sp = getSharedPreferences(packageName, Context.MODE_PRIVATE)
            val editor = sp.edit()

            if ( !ime.isNullOrEmpty() ) editor.putString(LoginActivity.IME, ime)
            if ( !prezime.isNullOrEmpty() ) editor.putString(LoginActivity.PREZIME, prezime)
            if ( !bolnica.isNullOrEmpty() ) editor.putString(LoginActivity.IME_BOLNICE, bolnica)

            editor.commit()

            setResult(Activity.RESULT_OK)
            finish()
        }

        btn_back.setOnClickListener {
            finish()
        }

    }
}
