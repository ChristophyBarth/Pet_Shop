package capps.teaching.petshop.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import capps.teaching.petshop.R
import capps.teaching.petshop.databinding.FragmentMoreImagesBinding

class MoreImagesFragment : Fragment() {
    private var _binding : FragmentMoreImagesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoreImagesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.webView.settings.javaScriptEnabled = false
        binding.webView.webViewClient = WebViewClient()
        binding.webView.loadUrl("https://www.pexels.com/search/dog%20and%20cat/")
    }


    override fun onDestroy() {
        super.onDestroy()

        _binding = null
    }
}