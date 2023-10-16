package capps.teaching.petshop.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import capps.teaching.petshop.OurObject
import capps.teaching.petshop.data.BackendReplica
import capps.teaching.petshop.databinding.FragmentAboutPetBinding
import capps.teaching.petshop.model.Pet
import com.bumptech.glide.Glide
import kotlin.properties.Delegates

class AboutPetFragment : Fragment() {
    private lateinit var pet: Pet
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


        when (category) {
            "dogs" -> {
                pet = BackendReplica().dogs().first {
                    it.id == petId
                }
            }

            "cats" -> {
                pet = BackendReplica().cats().first {
                    it.id == petId
                }
            }

            "snakes" -> {
                pet = BackendReplica().snakes().first {
                    it.id == petId
                }
            }/*"birds" ->{
                pet = BackendReplica().dogs().first {
                     it.id == petId
                }
            }*/
        }

        binding.apply {
            Glide.with(requireContext()).load(OurObject.imgurJPGLink(pet.photoUrl))
                .into(profilePicture)
            name.text = pet.name
            title.text = pet.title
            bio.text = pet.bio
            price.text = "$${pet.price.toString()}"
            ratingBar.rating = pet.rating!!.toFloat()



            Glide.with(requireContext()).load(OurObject.imgurJPGLink(pet.owner?.profilePic))
                .into(petOwnerProfilePicture)
            petOwnerName.text = pet.owner?.name
            petOwnerTitle.text = pet.owner?.title
            petOwnerDistance.text = "${pet.owner?.address} km"
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}