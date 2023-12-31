package capps.teaching.petshop.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import capps.teaching.petshop.OurObject
import capps.teaching.petshop.R
import capps.teaching.petshop.adapters.CategoryAdapter
import capps.teaching.petshop.adapters.PetsAdapter
import capps.teaching.petshop.data.BackendReplica
import capps.teaching.petshop.databinding.FragmentHomeBinding
import capps.teaching.petshop.model.Pet
import kotlin.math.max

class HomeFragment : Fragment() {

    companion object {
        const val TAG = "HomeFragment"
    }


    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var categoryNames: ArrayList<String>
    private lateinit var categoryIcons: ArrayList<Int>

    private lateinit var petsAdapter: PetsAdapter
    private lateinit var pets: ArrayList<Pet>

    private lateinit var backendReplica: BackendReplica

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            val slideUp = AnimationUtils.loadAnimation(requireContext(), R.anim.slide_up)
            val slideDown = AnimationUtils.loadAnimation(requireContext(), R.anim.slide_down)

            /*ObjectAnimator.ofFloat(profilePicture, "translationX", 0f, 200f).apply {
                duration = 3000
//                repeatCount = ValueAnimator.INFINITE
//                repeatMode = ValueAnimator.REVERSE
                addListener(object : Animator.AnimatorListener {
                    override fun onAnimationStart(animation: Animator) {
                        Log.d(TAG, "onAnimationStart: ")
                    }

                    override fun onAnimationEnd(animation: Animator) {
                        Log.d(TAG, "onAnimationEnd: ")
                    }

                    override fun onAnimationCancel(animation: Animator) {
                        Log.d(TAG, "onAnimationCancel:")
                    }

                    override fun onAnimationRepeat(animation: Animator) {
                        Log.d(TAG, "onAnimationRepeat: ")
                    }
                })
                start()
            }*/

            binding.apply {
                //"Squirrels", "Lizards", "Rabbits"
                categoryNames = arrayListOf(
                    getString(R.string.dogs),
                    getString(R.string.cats),
                    getString(R.string.birds),
                    getString(R.string.snakes)
                )

                categoryIcons = arrayListOf(
                    R.drawable.ic_dog, R.drawable.ic_cat, R.drawable.ic_bird, R.drawable.ic_snake
                )

                backendReplica = BackendReplica()

                categoryAdapter = CategoryAdapter(requireContext(),
                    categoryNames,
                    categoryIcons,
                    object : OurObject.OurItemClickListener {
                        override fun ourItemClick(position: Int) {
                            showPets(categoryNames[position])
                            petsAdapter.category = categoryNames[position].lowercase()
                        }
                    })

                categoriesRecyclerView.apply {
                    layoutManager =
                        LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                    adapter = categoryAdapter
                }

                pets = backendReplica.dogs()
                petsAdapter = PetsAdapter(pets, requireContext(), requireActivity())
                petsAdapter.category = getString(R.string.dogs).lowercase()
                binding.petsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
                binding.petsRecyclerView.adapter = petsAdapter

                searchCategory.isSubmitButtonEnabled = true
                searchCategory.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(query: String?): Boolean {
                        if (!query.isNullOrBlank()) {
                            searchForPets(query)
                        }
                        return true
                    }

                    override fun onQueryTextChange(newText: String?): Boolean {
                        return true
                    }

                })

                more.setOnClickListener {
                    val transaction = requireActivity().supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fragmentContainer, MoreImagesFragment())
                    transaction.addToBackStack(null)
                    transaction.commit()
                }
            }
        }
    }

    private fun searchForPets(query: String) {
        val filteredList = backendReplica.dogs().filter { pet ->
            pet.name!!.startsWith(query, true)
        }

        val previousListSize = pets.size
        pets.clear()
        pets.addAll(filteredList)
        petsAdapter.notifyItemRangeChanged(0, max(previousListSize, filteredList.size))
    }

    private fun showPets(category: String) {
        when (category) {
            getString(R.string.dogs) -> pets.apply {
                clear()
                addAll(backendReplica.dogs())
            }

            "Cats" -> pets.apply {
                clear()
                addAll(backendReplica.cats())
            }

            "Birds" -> pets.apply {
                clear()
                addAll(backendReplica.birds())
            }

            /*"Snakes" -> pets.apply {
            clear()
            addAll(arrayListOf("Slither", "Venom", "Cobra", "Medusa", "Python"))
            }*/

            /*"Birds" -> pets.apply {
            clear()
            addAll(arrayListOf("Tweety", "Sky", "Feather", "Merlin"))
            }

            "Squirrels" -> pets.apply {
            clear()
            addAll(arrayListOf("Nutty", "Squeaky", "Hazel", "Acorn", "Pippin"))
            }

            "Lizards" -> pets.apply {
            clear()
            addAll(arrayListOf("Spike", "Rex", "Lizzie", "Draco", "Ziggy", "Gex"))
            }

            "Rabbits" -> pets.apply {
            clear()
            addAll(
                arrayListOf(
                    "Floppy",
                    "Thumper",
                    "Cottontail",
                    "Binky",
                    "Snowball",
                    "Hopscotch",
                    "Daisy"
                )
            )
            }*/

            else -> throw IllegalArgumentException("Unknown Pet Category")
        }

        petsAdapter.notifyDataSetChanged()
    }

    override fun onDestroy() {
        super.onDestroy()

        _binding = null
    }
}