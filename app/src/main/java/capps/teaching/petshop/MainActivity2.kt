package capps.teaching.petshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import capps.teaching.petshop.adapters.PetsAdapter
import capps.teaching.petshop.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    private lateinit var category: String

    private lateinit var pets : ArrayList<String>
    private lateinit var petsAdapter: PetsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main2)

        val extras = intent.extras
        if (extras != null){
            category = extras.getString("category").toString()
            binding.categoryName.text = category
        }

        when(category){
            "Dogs" -> pets = arrayListOf("Pluto", "Max", "Jack", "Boogie", "Billy", "Densy")
            "Cats" -> pets = arrayListOf("Whiskers", "Mittens", "Luna")
            "Snakes" -> pets = arrayListOf()
            "Birds" -> pets = arrayListOf("Tweety", "Sky", "Feather", "Merlin")
            "Squirrels" -> pets = arrayListOf("Nutty", "Squeaky", "Hazel", "Acorn", "Pippin")
            "Lizards" -> pets = arrayListOf("Spike", "Rex", "Lizzie", "Draco", "Ziggy", "Gex")
            "Rabbits" -> pets = arrayListOf("Floppy", "Thumper", "Coottontail", "Binky", "Snowball", "Hopscotch", "Daisy")
            else -> pets = arrayListOf()
        }


        petsAdapter = PetsAdapter(pets)
        binding.petsRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.petsRecyclerView.adapter = petsAdapter
    }
}