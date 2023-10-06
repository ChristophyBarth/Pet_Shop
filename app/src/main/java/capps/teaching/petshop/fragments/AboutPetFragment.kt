package capps.teaching.petshop.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import capps.teaching.petshop.databinding.FragmentAboutPetBinding
import com.bumptech.glide.Glide

class AboutPetFragment : Fragment() {
    lateinit var binding: FragmentAboutPetBinding
    private lateinit var petName: String
    private lateinit var otherPets: ArrayList<String>

    private val funnyGif =
        "https://gifdb.com/images/high/funny-baby-falling-in-the-pool-adcl8uxuk79qk7bb.webp"
    private val petImageLink =
        "https://images.rawpixel.com/image_800/cHJpdmF0ZS9sci9pbWFnZXMvd2Vic2l0ZS8yMDIzLTA4L3Jhd3BpeGVsX29mZmljZV8xNV9waG90b19vZl9hX2RvZ19ydW5uaW5nX3dpdGhfb3duZXJfYXRfcGFya19lcF9mM2I3MDQyZC0zNWJlLTRlMTQtOGZhNy1kY2Q2OWQ1YzQzZjlfMi5qcGc.jpg"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentAboutPetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val extras = arguments
        petName = extras?.getString("petName").toString()

        otherPets = extras?.getStringArrayList("others")!!
        otherPets.remove(petName)

        Glide.with(this).load(funnyGif).into(binding.petImage)

        for (i in otherPets) {
            Log.d("others", i)
        }
    }
}