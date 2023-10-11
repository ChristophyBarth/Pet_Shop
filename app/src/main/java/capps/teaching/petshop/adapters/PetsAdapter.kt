package capps.teaching.petshop.adapters

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import capps.teaching.petshop.OurObject.imgurJPGLink
import capps.teaching.petshop.OurObject.isColorDark
import capps.teaching.petshop.R
import capps.teaching.petshop.databinding.PetItemBinding
import capps.teaching.petshop.model.Pet
import com.bumptech.glide.Glide

class PetsAdapter(private val petList: ArrayList<Pet>, private val context: Context) :
    RecyclerView.Adapter<PetsAdapter.PetsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = PetItemBinding.inflate(
            layoutInflater, parent, false
        )
        return PetsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return petList.size
    }

    override fun onBindViewHolder(holder: PetsViewHolder, position: Int) {
        holder.bind(petList[position])
    }

    inner class PetsViewHolder(private val binding: PetItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pet: Pet) {
            binding.apply {
                name.text = pet.name
                bio.text = pet.bio
                rating.rating = pet.rating!!.toFloat()
                price.text = "$${pet.price}"

                rating.progressTintList = ColorStateList.valueOf(ContextCompat.getColor(context, R.color.filled_star_light))

                if (pet.themeColor != null){
                    background.setBackgroundColor(Color.parseColor(pet.themeColor))

                    if (isColorDark(pet.themeColor!!)){
                        name.setTextColor(Color.WHITE)
                        bio.setTextColor(Color.WHITE)
                        price.setTextColor(Color.WHITE)
                    }else{
                        name.setTextColor(Color.BLACK)
                        bio.setTextColor(Color.BLACK)
                        price.setTextColor(Color.BLACK)
                    }
                }

                Glide.with(context).load(imgurJPGLink(pet.photoUrl!!)).into(photo)
            }


            binding.root.setOnClickListener {
                /*val intent = Intent(context, AboutPetActivity::class.java)
                val bundle = Bundle()
                bundle.putString("petName", pet)
                bundle.putStringArrayList("others", petList)
                intent.putExtras(bundle)
                context.startActivity(intent)*/
            }
        }
    }
}