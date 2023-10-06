package capps.teaching.petshop.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import capps.teaching.petshop.OurObject
import capps.teaching.petshop.R
import capps.teaching.petshop.databinding.CategoryItemBinding

class CategoryAdapter(
    private val categoryNameList: ArrayList<String>,
    private val categoryIconList: ArrayList<Int>,
    private val onItemClickListener: OurObject.OurItemClickListener,
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<CategoryItemBinding>(
            layoutInflater, R.layout.category_item, parent, false
        )
        return CategoryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return categoryNameList.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categoryNameList[position], categoryIconList[position], onItemClickListener)
    }

    inner class CategoryViewHolder(private val binding: CategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(category: String, icon: Int, onItemClickListener: OurObject.OurItemClickListener) {
            binding.category.text = category
            binding.icon.setImageResource(icon)

            binding.root.setOnClickListener {
                onItemClickListener.ourItemClick(adapterPosition)
            }
        }
    }

}

