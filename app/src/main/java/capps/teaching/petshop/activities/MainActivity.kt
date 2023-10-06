package capps.teaching.petshop.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import capps.teaching.petshop.R
import capps.teaching.petshop.databinding.ActivityMainBinding
import capps.teaching.petshop.fragments.HomeFragment
import capps.teaching.petshop.fragments.SettingsFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        changeFragment(HomeFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> {
                    changeFragment(HomeFragment())
                }

                R.id.nav_chat -> {
                    Toast.makeText(
                        this,
                        "This feature has not been implemented yet.",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                R.id.nav_notification -> {
                    Toast.makeText(
                        this,
                        "This feature has not been implemented yet.",
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

    private fun changeFragment(id : Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, id)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}