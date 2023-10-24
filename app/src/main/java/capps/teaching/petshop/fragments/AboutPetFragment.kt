package capps.teaching.petshop.fragments

import NotificationService
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import capps.teaching.petshop.OurObject
import capps.teaching.petshop.data.BackendReplica
import capps.teaching.petshop.databinding.FragmentAboutPetBinding
import capps.teaching.petshop.model.Pet
import com.bumptech.glide.Glide
import com.google.gson.Gson
import kotlin.properties.Delegates

class AboutPetFragment : Fragment() {
    private var pet: Pet? = null
    private var petId by Delegates.notNull<Int>()
    private var _binding: FragmentAboutPetBinding? = null
    private val binding get() = _binding!!

    private lateinit var category: String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutPetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val extras = requireArguments()
        petId = extras.getInt("petId")
        category = extras.getString("category")!!

        val jsonString = extras.getString("pet")
        val gson = Gson()
        pet = gson.fromJson(jsonString, Pet::class.java)

        Log.wtf("TAGGG", petId.toString())
        Log.wtf("TAGGG", category)
        Log.d(OurObject.TAG, "onViewCreated: ")


        binding.adoptBtn.setOnClickListener {
            fun createNotificationChannel() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    val adoptionChannel = NotificationChannel(
                        NotificationService.ORDER_CHANNEL_ID,
                        "Adoption",
                        NotificationManager.IMPORTANCE_DEFAULT
                    )
                    adoptionChannel.description = "Adoptions"
                    val notificationManager = requireContext().getSystemService(Context.NOTIFICATION_SERVICE)
                }

            }
        }

        /*when (category) {
            "dogs" -> {
                pet = BackendReplica().dogs().find {
                    it.id == petId
                }
            }

            "cats" -> {
                pet = BackendReplica().cats().first {
                    it.id == petId
                }
            }

            "birds" -> {
                pet = BackendReplica().birds().first {
                    it.id == petId
                }
            }
            *//*"birds" ->{
                    pet = BackendReplica().dogs().first {
                         it.id == petId
                    }
                }*//*
        }*/

        binding.apply {
            Glide.with(requireContext()).load(OurObject.imgurJPGLink(pet?.photoUrl))
                .into(profilePicture)
            name.text = pet?.name
            title.text = pet?.title
            bio.text = pet?.bio
            price.text = "$${pet?.price.toString()}"

            if (pet?.rating != null) {
                ratingBar.rating = pet!!.rating!!.toFloat()
            }
            ageValue.text = "${pet?.info?.age} yrs"
            breedValue.text = pet?.info?.breed.toString()
            weightValue.text = "${pet?.info?.weight.toString()} kg"
            sexValue.text = pet?.info?.gender.toString()


            if (id == 0 && category == "dogs") {
                Glide.with(requireContext()).load(OurObject.imgurJPGLink(pet?.owner?.profilePic))
                    .into(petOwnerProfilePicture)
            } else {
                Glide.with(requireContext()).load(pet?.owner?.profilePic)
                    .into(petOwnerProfilePicture)
            }





            petOwnerName.text = pet?.owner?.name
            petOwnerTitle.text = pet?.owner?.title
            petOwnerDistance.text = "${pet?.owner?.address} km"
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}