package capps.teaching.petshop.adapters

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import capps.teaching.petshop.OurObject
import capps.teaching.petshop.OurObject.TAG
import capps.teaching.petshop.OurObject.imgurJPGLink
import capps.teaching.petshop.OurObject.isColorDark
import capps.teaching.petshop.R
import capps.teaching.petshop.databinding.PetItemBinding
import capps.teaching.petshop.fragments.AboutPetFragment
import capps.teaching.petshop.model.Pet
import com.bumptech.glide.Glide
import com.google.gson.Gson

class PetsAdapter(
    private val petList: ArrayList<Pet>,
    private val context: Context,
    private val activity: FragmentActivity
) :
    RecyclerView.Adapter<PetsAdapter.PetsViewHolder>() {
    private val slideLeft = AnimationUtils.loadAnimation(context, R.anim.slide_left)
    private val fadeOut = AnimationUtils.loadAnimation(context, R.anim.fade_in)
    lateinit var category: String

    companion object{
        const val TAG = "PetsAdapter"
    }


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

        private val slideDown = AnimationUtils.loadAnimation(context, R.anim.slide_down)
        fun bind(pet: Pet) {
            binding.apply {
                name.text = pet.name
                title.text = pet.title
                rating.rating = pet.rating!!.toFloat()
                price.text = "$${pet.price}"

                if (pet.themeColor != null) {
                    background.setBackgroundColor(Color.parseColor(pet.themeColor))

                    if (isColorDark(pet.themeColor!!)) {
                        name.setTextColor(Color.WHITE)
                        title.setTextColor(Color.WHITE)
                        price.setTextColor(Color.WHITE)
                    } else {
                        name.setTextColor(Color.BLACK)
                        title.setTextColor(Color.BLACK)
                        price.setTextColor(Color.BLACK)
                    }
                }

                Glide.with(context).load(imgurJPGLink(pet.photoUrl!!)).into(photo)

                root.startAnimation(fadeOut)
            }


            binding.root.setOnClickListener {
                val bundle = Bundle()
                bundle.putInt(OurObject.PET_ID, pet.id!!)
                bundle.putString("category", category)

                val gson = Gson()
                val jsonString = gson.toJson(pet)

                Log.d(TAG, jsonString)

                bundle.putString("pet", jsonString)

                val newFragment = AboutPetFragment()
                newFragment.arguments = bundle

                activity.supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, newFragment).addToBackStack(null).commit()
            }
        }
    }
}