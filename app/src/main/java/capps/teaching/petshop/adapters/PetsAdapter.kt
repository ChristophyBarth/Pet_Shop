package capps.teaching.petshop.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import capps.teaching.petshop.R
import capps.teaching.petshop.databinding.CategoryItemBinding

class PetsAdapter(private val petList: ArrayList<String>) : RecyclerView.Adapter<PetsAdapter.PetsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<CategoryItemBinding>(layoutInflater, R.layout.category_item, parent, false)
        return PetsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return petList.size
    }

    override fun onBindViewHolder(holder: PetsViewHolder, position: Int) {
        holder.bind(petList[position])
    }

    inner class PetsViewHolder(private val binding: CategoryItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(petName: String){
            binding.category.text = petName
            binding.delete.visibility = View.INVISIBLE
        }
    }
}