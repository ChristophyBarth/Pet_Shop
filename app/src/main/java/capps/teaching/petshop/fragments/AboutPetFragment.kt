package capps.teaching.petshop.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import capps.teaching.petshop.databinding.FragmentAboutPetBinding

class AboutPetFragment : Fragment() {
    private var _binding: FragmentAboutPetBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutPetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val extras = arguments


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}