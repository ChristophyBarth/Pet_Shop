package capps.teaching.petshop.adapters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import capps.teaching.petshop.MainActivity2
import capps.teaching.petshop.R
import capps.teaching.petshop.databinding.CategoryItemBinding

class CategoryAdapter(private val categoryList: ArrayList<String>, private val context: Context) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<CategoryItemBinding>(
            layoutInflater, R.layout.category_item, parent, false
        )
        return CategoryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categoryList[position])
    }

    inner class CategoryViewHolder(private val binding: CategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(category: String) {
            binding.category.text = category

            binding.delete.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    categoryList.removeAt(adapterPosition)
                    Toast.makeText(context, "$category category deleted.", Toast.LENGTH_SHORT)
                        .show()
                    notifyItemRemoved(adapterPosition)
                }
            }

            binding.root.setOnClickListener {
                val intent = Intent(context, MainActivity2::class.java)
                val bundle = Bundle()
                bundle.putString("category", category)
                intent.putExtras(bundle)
                context.startActivity(intent)
            }
        }
    }

}

