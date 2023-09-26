package capps.teaching.petshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import capps.teaching.petshop.adapters.CategoryAdapter
import capps.teaching.petshop.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var categories: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            categories = arrayListOf(
                "Dogs", "Cats", "Birds", "Squirrels", "Lizards", "Rabbits", "Snakes"
            )

            categoryAdapter = CategoryAdapter(categories, this@MainActivity)
            categoriesRecyclerView.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
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
                val intent = Intent(this@MainActivity, SettingsActivity::class.java)
                startActivity(intent)
            }
        }
    }
}