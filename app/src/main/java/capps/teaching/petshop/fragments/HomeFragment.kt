package capps.teaching.petshop.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
import java.util.Locale

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var categoryNames: ArrayList<String>
    private lateinit var categoryIcons: ArrayList<Int>

    private lateinit var petsAdapter: PetsAdapter
    private lateinit var pets: ArrayList<Pet>

    private lateinit var backendReplica: BackendReplica

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            //"Squirrels", "Lizards", "Rabbits"
            categoryNames = arrayListOf(
                "Dogs", "Cats", "Birds", "Snakes"
            )

            categoryIcons = arrayListOf(
                R.drawable.ic_dog, R.drawable.ic_cat, R.drawable.ic_bird, R.drawable.ic_snake
            )

            backendReplica = BackendReplica()

            categoryAdapter = CategoryAdapter(categoryNames,
                categoryIcons,
                object : OurObject.OurItemClickListener {
                    override fun ourItemClick(position: Int) {
                        showPets(categoryNames[position])
                    }
                })

            categoriesRecyclerView.apply {
                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                adapter = categoryAdapter
            }

            pets = backendReplica.dogs()
            petsAdapter = PetsAdapter(pets, requireContext())
            binding.petsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
            binding.petsRecyclerView.adapter = petsAdapter

            searchCategory.isSubmitButtonEnabled = true
            searchCategory.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    val thePet = pets.firstOrNull{
                        it.name?.lowercase(Locale.getDefault()) == query?.lowercase(Locale.getDefault())
                    }

                    /*val  newList = pets.filter {
                        it.name == query
                    }*/

                    pets.clear()
                    petsAdapter.notifyItemRangeRemoved(0, pets.size)

                    Log.d("TEsting", pets.size.toString())

                    //\uf8ff
                    /*pets.add(thePet!!)
                    categoryAdapter.notifyItemInserted(pets.size - 1)*/

                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    return true
                }

            })
        }
    }

    private fun showPets(category: String) {
        when (category) {
            "Dogs" -> pets.apply {
                clear()
                addAll(backendReplica.dogs())
            }

            "Cats" -> pets.apply {
                clear()
                addAll(backendReplica.cats())
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
                        "Coottontail",
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
}