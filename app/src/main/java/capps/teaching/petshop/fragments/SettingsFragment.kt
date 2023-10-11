package capps.teaching.petshop.fragments

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import capps.teaching.petshop.R
import capps.teaching.petshop.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {
    private lateinit var binding: FragmentSettingsBinding
    private lateinit var sharedPreferences: SharedPreferences
    private val sharedPrefKey = "SettingsPrefs"

    private lateinit var photoIntentLauncher: ActivityResultLauncher<Intent>

    companion object {
        const val OUR_IMAGE_REQUEST_CODE = 1
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        photoIntentLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val data = result.data
                    val uri = data!!.data
                    binding.imageView.setImageURI(uri)
                }
            }

        sharedPreferences =
            requireContext().getSharedPreferences(sharedPrefKey, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        if (sharedPreferences.contains("darkMode")) {

            val darkMode = sharedPreferences.getBoolean("darkMode", false)
            binding.darkModeSwitch.isChecked = darkMode

            if (darkMode) {
                binding.root.setBackgroundColor(
                    ContextCompat.getColor(
                        requireContext(), R.color.black
                    )
                )
                binding.darkModeTextView.setTextColor(
                    ContextCompat.getColor(
                        requireContext(), R.color.white
                    )
                )
            } else {
                binding.root.setBackgroundColor(
                    ContextCompat.getColor(
                        requireContext(), R.color.white
                    )
                )
                binding.darkModeTextView.setTextColor(
                    ContextCompat.getColor(
                        requireContext(), R.color.black
                    )
                )
            }
        }

        binding.darkModeSwitch.setOnCheckedChangeListener { _, darkModeEnabled ->
            if (darkModeEnabled) {
                binding.root.setBackgroundColor(
                    ContextCompat.getColor(
                        requireContext(), R.color.black
                    )
                )
                binding.darkModeTextView.setTextColor(
                    ContextCompat.getColor(
                        requireContext(), R.color.white
                    )
                )
            } else {
                binding.root.setBackgroundColor(
                    ContextCompat.getColor(
                        requireContext(), R.color.white
                    )
                )
                binding.darkModeTextView.setTextColor(
                    ContextCompat.getColor(
                        requireContext(), R.color.black
                    )
                )
            }

            editor.putBoolean("darkMode", darkModeEnabled)
            editor.apply()
        }

        binding.imageView.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            photoIntentLauncher.launch(intent)
        }

//        binding.imageView.setOnClickListener {
//            val intent = Intent(Intent.ACTION_GET_CONTENT)
//            intent.type = "image/*"
//            startActivityForResult(intent, OUR_IMAGE_REQUEST_CODE)
//        }
    }

    /*override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode) {
               OUR_IMAGE_REQUEST_CODE -> {
                   val imageUri = data?.data
                   binding.imageView.setImageURI(imageUri)
               }
        }
    }*/
}