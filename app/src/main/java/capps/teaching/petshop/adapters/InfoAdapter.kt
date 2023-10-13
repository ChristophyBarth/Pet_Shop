package capps.teaching.petshop.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import capps.teaching.petshop.databinding.PetInfoBinding
import capps.teaching.petshop.model.Pet

class InfoAdapter(private val InfoList: ArrayList<Pet>, private val context: Context) :
    RecyclerView.Adapter<InfoAdapter.InfoViewHolder>() {
    inner class InfoViewHolder(private val binding: PetInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pet: Pet) {
            binding.petName.text = pet.name
            binding.priceValue.text = "$${pet.price.toString()}"
            binding.bioTxt.text = pet.bio
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = PetInfoBinding.inflate(layoutInflater, parent, false)
        return InfoViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return InfoList.size
    }

    override fun onBindViewHolder(holder: InfoViewHolder, position: Int) {
        val pet = InfoList[position]
        holder.bind(pet)
    }
}