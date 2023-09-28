package capps.teaching.petshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import capps.teaching.petshop.databinding.ActivityAboutPetBinding
import com.bumptech.glide.Glide

class AboutPetActivity : AppCompatActivity() {
    private lateinit var petName: String
    private lateinit var binding: ActivityAboutPetBinding
    private lateinit var otherPets: ArrayList<String>

    private val funnyGif = "https://gifdb.com/images/high/funny-baby-falling-in-the-pool-adcl8uxuk79qk7bb.webp"
    private val petImageLink = "https://images.rawpixel.com/image_800/cHJpdmF0ZS9sci9pbWFnZXMvd2Vic2l0ZS8yMDIzLTA4L3Jhd3BpeGVsX29mZmljZV8xNV9waG90b19vZl9hX2RvZ19ydW5uaW5nX3dpdGhfb3duZXJfYXRfcGFya19lcF9mM2I3MDQyZC0zNWJlLTRlMTQtOGZhNy1kY2Q2OWQ1YzQzZjlfMi5qcGc.jpg"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_about_pet)

        val extras = intent.extras
        petName = extras?.getString("petName").toString()

        otherPets = extras?.getStringArrayList("others")!!
        otherPets.remove(petName)

        Glide.with(this).load(funnyGif).into(binding.petImage)

        for (i in otherPets) {
            Log.d("others", i)
        }
    }
}