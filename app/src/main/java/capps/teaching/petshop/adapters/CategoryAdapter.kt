package capps.teaching.petshop.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import capps.teaching.petshop.OurObject
import capps.teaching.petshop.R
import capps.teaching.petshop.databinding.CategoryItemBinding

class CategoryAdapter(
    private val context: Context,
    private val categoryNameList: ArrayList<String>,
    private val categoryIconList: ArrayList<Int>,
    private val onItemClickListener: OurObject.OurItemClickListener,
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    private var selectedItemPosition = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CategoryItemBinding.inflate(layoutInflater, parent,false)
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

            //selected Item default = 0
            //(0) 1 2 3

            if (adapterPosition == selectedItemPosition) {
                binding.linearLayout.setBackgroundResource(R.drawable.selected_category_background)
            } else {
                binding.linearLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.ash_white))
            }

            binding.category.text = category
            binding.icon.setImageResource(icon)

            binding.root.setOnClickListener {
                onItemClickListener.ourItemClick(adapterPosition)

                notifyItemChanged(selectedItemPosition)

                selectedItemPosition = adapterPosition
                notifyItemChanged(adapterPosition)
            }
        }
    }

}

