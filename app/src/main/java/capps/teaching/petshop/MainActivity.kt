package capps.teaching.petshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import capps.teaching.petshop.adapters.CategoryAdapter
import capps.teaching.petshop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var categories: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            categories = arrayListOf(
                "Dogs",
                "Cats",
                "Birds",
                "Squirrels",
                "Lizards",
                "Rabbits",
                "Snakes"
            )

            categoryAdapter = CategoryAdapter(categories, this@MainActivity)
            categoriesRecyclerView.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = categoryAdapter
            }

            add.setOnClickListener {
                if (newCategoryEd.text.isNotBlank()){
                    categories.add(newCategoryEd.text.toString())
                    newCategoryEd.setText("")
                    categoryAdapter.notifyItemInserted(categories.size)
                }
            }
        }
    }
}