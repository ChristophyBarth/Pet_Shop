package capps.teaching.petshop.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import capps.teaching.petshop.R
import capps.teaching.petshop.databinding.ActivityMainBinding
import capps.teaching.petshop.fragments.HomeFragment
import capps.teaching.petshop.fragments.SettingsFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        changeFragment(HomeFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> {
                    changeFragment(HomeFragment())
                }

                R.id.nav_chat -> {
                    Toast.makeText(
                        this,
                        getString(R.string.feature_not_implemented),
                        Toast.LENGTH_SHORT
                    ).show()
                }

                R.id.nav_notification -> {
                    Toast.makeText(
                        this,
                        getString(R.string.feature_not_implemented),
                        Toast.LENGTH_SHORT
                    ).show()
                }

                R.id.nav_profile -> {
                    changeFragment(SettingsFragment())
                }
            }

            true
        }
    }

    private fun changeFragment(id: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, id)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}