package capps.teaching.petshop

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import capps.teaching.petshop.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var binding: ActivitySettingsBinding
    private val sharedPrefKey = "SettingsPrefs"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_settings)

        sharedPreferences = getSharedPreferences(sharedPrefKey, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        if (sharedPreferences.contains("darkMode")) {

            val darkMode = sharedPreferences.getBoolean("darkMode", false)
            binding.darkModeSwitch.isChecked = darkMode

            if (darkMode) {
                binding.root.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
                binding.darkModeTextView.setTextColor(ContextCompat.getColor(this, R.color.white))
            } else {
                binding.root.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
                binding.darkModeTextView.setTextColor(ContextCompat.getColor(this, R.color.black))
            }
        }

        binding.darkModeSwitch.setOnCheckedChangeListener { _, darkModeEnabled ->
            if (darkModeEnabled) {
                binding.root.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
                binding.darkModeTextView.setTextColor(ContextCompat.getColor(this, R.color.white))
            } else {
                binding.root.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
                binding.darkModeTextView.setTextColor(ContextCompat.getColor(this, R.color.black))
            }

            editor.putBoolean("darkMode", darkModeEnabled)
            editor.apply()
        }


    }
}