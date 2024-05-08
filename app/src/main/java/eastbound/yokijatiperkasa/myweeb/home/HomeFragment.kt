package eastbound.yokijatiperkasa.myweeb.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Space
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import eastbound.yokijatiperkasa.myweeb.R
import eastbound.yokijatiperkasa.myweeb.core.data.AnimeRepository
import eastbound.yokijatiperkasa.myweeb.core.data.source.remote.network.ApiConfig
import eastbound.yokijatiperkasa.myweeb.core.ui.adapter.TopAnimeAdapter
import eastbound.yokijatiperkasa.myweeb.core.utils.HorizontalSpaceItemDecoration
import eastbound.yokijatiperkasa.myweeb.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: TopAnimeAdapter
    private lateinit var viewModel: HomeViewModel

    private lateinit var viewModelFactory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupViewModel()
        fetchTopAnime()

    }

    private fun setupViewModel() {
        val animeRepository = AnimeRepository(ApiConfig.getApiService())
        viewModelFactory = ViewModelFactory(animeRepository)
        viewModel = ViewModelProvider(this, viewModelFactory)[HomeViewModel::class.java]
        viewModel.topAnime.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun setupRecyclerView() {
        adapter = TopAnimeAdapter()
        binding.rvTopAnime.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvTopAnime.adapter = adapter

        val horizontalSpaceItemDecoration = resources.getDimensionPixelSize(R.dimen.horizontal_space_width)
        val itemDecoration = HorizontalSpaceItemDecoration(horizontalSpaceItemDecoration)
        binding.rvTopAnime.addItemDecoration(itemDecoration)

//        val dividerItemDecoration = DividerItemDecoration(
//            requireContext(),
//            LinearLayoutManager.HORIZONTAL
//        )
//        binding.rvTopAnime.addItemDecoration(dividerItemDecoration)
    }

    private fun fetchTopAnime() {
        viewModel.fetchTopAnime()
    }


    companion object {
        fun newInstance(): HomeFragment {
            val fragment = HomeFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

}