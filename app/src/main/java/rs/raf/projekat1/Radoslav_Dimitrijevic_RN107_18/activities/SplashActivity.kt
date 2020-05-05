package rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedResources = getSharedPreferences(packageName, Context.MODE_PRIVATE)

        val startIntent: Intent

        startIntent = if( sharedResources.getString(LoginActivity.IME, "").isNullOrEmpty() ) {
            Intent(this, LoginActivity::class.java)
        } else {
            Intent(this, MainActivity::class.java)
        }

        startActivity(startIntent)
        finish()
    }
}
