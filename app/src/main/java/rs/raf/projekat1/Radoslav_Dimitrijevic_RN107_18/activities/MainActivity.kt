package rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.R

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        initListeners()
    }

    private fun initListeners() {
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
    }
}
