package capps.teaching.petshop

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import capps.teaching.petshop.adapters.CategoryAdapter
import capps.teaching.petshop.databinding.FragmentHomeBinding
import com.google.android.material.snackbar.Snackbar
import java.util.Locale

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var categories: ArrayList<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        binding.apply {
            categories = arrayListOf(
                "Dogs", "Cats", "Birds", "Squirrels", "Lizards", "Rabbits", "Snakes"
            )

            categoryAdapter = CategoryAdapter(categories, requireContext())
            categoriesRecyclerView.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = categoryAdapter
            }

            add.setOnClickListener {
                if (newCategoryEd.text.length >= 2) {
                    val lowerCaseCategories = categories.map {
                        it.lowercase(Locale.ROOT)
                    }

                    if (!lowerCaseCategories.contains(
                            newCategoryEd.text.trim().toString().lowercase(
                                Locale.ROOT
                            )
                        )
                    ) {
                        categories.add(newCategoryEd.text.toString())
                        newCategoryEd.setText("")
                        categoryAdapter.notifyItemInserted(categories.size)
                    } else {
                        Snackbar.make(
                            binding.root, "We already have this pet in store.", Snackbar.LENGTH_LONG
                        ).show()
                    }
                } else {
                    Snackbar.make(binding.root, "Name too short.", Snackbar.LENGTH_LONG).show()
                }
            }

            settings.setOnClickListener {
                val intent = Intent(requireContext(), SettingsActivity::class.java)
                startActivity(intent)
            }
        }

        return binding.root
    }
}