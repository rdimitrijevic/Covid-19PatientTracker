package rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import kotlinx.android.synthetic.main.activity_main.*
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.R
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.viewmodels.MainViewModel

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        initSelection(mainViewModel.getSelected().value ?: 1)
        initListeners()
    }

    private fun initSelection(sel: Int) {
        main_btn_stanje.isChecked = sel == 1
        main_btn_unos.isChecked = sel == 2
        main_btn_liste.isChecked = sel == 3
        main_btn_profil.isChecked = sel == 4
    }

    private fun initListeners() {
/*
        main_logout_btn.setOnClickListener {
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
*/

        main_btn_stanje.setOnClickListener {
            mainViewModel.setSelected(1)
            initSelection(1)
        }

        main_btn_unos.setOnClickListener {
            mainViewModel.setSelected(2)
            initSelection(2)
        }

        main_btn_liste.setOnClickListener {
            mainViewModel.setSelected(3)
            initSelection(3)
        }

        main_btn_profil.setOnClickListener {
            mainViewModel.setSelected(4)
            initSelection(4)
        }
    }
}
