package eastbound.yokijatiperkasa.myweeb.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import eastbound.yokijatiperkasa.myweeb.R
import eastbound.yokijatiperkasa.myweeb.core.data.source.remote.respone.ImageData
import eastbound.yokijatiperkasa.myweeb.core.ui.adapter.TopAnimeAdapter
import eastbound.yokijatiperkasa.myweeb.core.utils.CommontUtils
import eastbound.yokijatiperkasa.myweeb.core.utils.HorizontalSpaceItemDecoration
import eastbound.yokijatiperkasa.myweeb.databinding.FragmentHomeBinding
import eastbound.yokijatiperkasa.myweeb.di.MyInjection

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
//        Inisiasi ViewModel
        viewModelFactory = ViewModelFactory(MyInjection.provideRepository())
        viewModel =
            ViewModelProvider(requireActivity(), viewModelFactory)[HomeViewModel::class.java]

        setupRecyclerViewTopAnime()
        fetchTopAnime()
        fetchRandomAnime()
    }


    private fun setupRecyclerViewTopAnime() {
        adapter = TopAnimeAdapter()
        binding.rvTopAnime.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvTopAnime.adapter = adapter

        val horizontalSpaceItemDecoration =
            resources.getDimensionPixelSize(R.dimen.horizontal_space_width)
        val itemDecoration = HorizontalSpaceItemDecoration(horizontalSpaceItemDecoration)
        binding.rvTopAnime.addItemDecoration(itemDecoration)

    }

    private fun fetchTopAnime() {
        CommontUtils.showLoading(binding.loadingTopAnime, true)
        viewModel.topAnime.observe(viewLifecycleOwner) {
            adapter.submitList(it)
            CommontUtils.showLoading(binding.loadingTopAnime, false)
        }
    }

    private fun fetchRandomAnime() {
        viewModel.getRandomAnime()

        viewModel.randomAnime.observe(viewLifecycleOwner) {
            it?.let {
                binding.ivRandomAnime.visibility = View.VISIBLE
                Glide.with(this@HomeFragment)
                    .load(it.images.jpg.imageUrl)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(binding.ivRandomAnime)
            }

        }
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