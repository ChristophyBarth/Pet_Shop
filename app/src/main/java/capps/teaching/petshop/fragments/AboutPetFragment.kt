package capps.teaching.petshop.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import capps.teaching.petshop.adapters.InfoAdapter
import capps.teaching.petshop.databinding.FragmentAboutPetBinding
import capps.teaching.petshop.model.Pet

class AboutPetFragment : Fragment() {
    private var _binding: FragmentAboutPetBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutPetBinding.inflate(inflater, container, false)
        val view = binding.root


        val InfoList = ArrayList<Pet>()
        val adapter = InfoAdapter(InfoList, requireContext())
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val extras = arguments
        val petName = extras?.getString("petName").toString()
        val themeColor = extras?.getString("themeColor")
        val bio = extras?.getString("bio")
        val price = extras?.getFloat("price")
        val rating = extras?.getFloat("rating")
binding.apply {

}

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}