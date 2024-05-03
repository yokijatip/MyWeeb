package eastbound.yokijatiperkasa.myweeb.library

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import eastbound.yokijatiperkasa.myweeb.R
import eastbound.yokijatiperkasa.myweeb.databinding.FragmentLibraryBinding
import eastbound.yokijatiperkasa.myweeb.home.HomeFragment

class LibraryFragment : Fragment() {

    private lateinit var binding: FragmentLibraryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLibraryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    companion object {
        fun newInstance(): LibraryFragment {
            val fragment = LibraryFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}