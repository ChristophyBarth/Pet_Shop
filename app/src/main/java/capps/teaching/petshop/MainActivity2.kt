package capps.teaching.petshop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import capps.teaching.petshop.adapters.PetsAdapter
import capps.teaching.petshop.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    private lateinit var category: String
    private lateinit var pets: ArrayList<String>
    private lateinit var petsAdapter: PetsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main2)

        val extras = intent.extras
        if (extras != null) {
            category = extras.getString("category").toString()
            binding.categoryName.text = category
        }

        pets = when (category) {
            "Dogs" -> arrayListOf("Pluto", "Max", "Jack", "Boogie", "Billy", "Densy")
            "Cats" -> arrayListOf("Whiskers", "Mittens", "Luna")
            "Snakes" -> arrayListOf()
            "Birds" -> arrayListOf("Tweety", "Sky", "Feather", "Merlin")
            "Squirrels" -> arrayListOf("Nutty", "Squeaky", "Hazel", "Acorn", "Pippin")
            "Lizards" -> arrayListOf("Spike", "Rex", "Lizzie", "Draco", "Ziggy", "Gex")
            "Rabbits" -> arrayListOf(
                "Floppy", "Thumper", "Coottontail", "Binky", "Snowball", "Hopscotch", "Daisy"
            )

            else -> arrayListOf()
        }

        petsAdapter = PetsAdapter(pets, this)
        binding.petsRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.petsRecyclerView.adapter = petsAdapter
    }
}