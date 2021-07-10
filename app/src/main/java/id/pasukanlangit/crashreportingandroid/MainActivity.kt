package id.pasukanlangit.crashreportingandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.FirebaseApp
import com.google.firebase.crashlytics.FirebaseCrashlytics
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import java.lang.Exception
import java.lang.RuntimeException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Timber.d("Test debugging")

        btn_crash.setOnClickListener {
            FirebaseCrashlytics.getInstance().log("clicked on button")
            FirebaseCrashlytics.getInstance().setCustomKey("str_key","some_value")
            try {
                throw RuntimeException("Test Crash")
            }catch (e: Exception){
                Timber.e("test not fatal exception")
            }
        }

    }
}