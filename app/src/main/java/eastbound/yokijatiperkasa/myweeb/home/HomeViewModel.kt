package eastbound.yokijatiperkasa.myweeb.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import eastbound.yokijatiperkasa.myweeb.core.data.AnimeRepository
import eastbound.yokijatiperkasa.myweeb.core.data.source.remote.respone.AnimeItem
import kotlinx.coroutines.launch

class HomeViewModel(private var animeRepository: AnimeRepository) : ViewModel() {

    private val _topAnime = MutableLiveData<List<AnimeItem>>()
    val topAnime: LiveData<List<AnimeItem>> get() = _topAnime

    init {
        fetchTopAnime()
    }

    private fun fetchTopAnime() {
        viewModelScope.launch {
            if (_topAnime.value.isNullOrEmpty()) {
                _topAnime.value = animeRepository.getTopAnime()
            }
        }
    }

    private val _randomAnime = MutableLiveData<AnimeItem>()
    val randomAnime: LiveData<AnimeItem> get() = _randomAnime

    fun getRandomAnime() {
        viewModelScope.launch {
            try {
                val randomAnimeItem = animeRepository.getRandomAnime()
                _randomAnime.value = randomAnimeItem
            } catch (e: Exception) {
                Log.e("Jikan_API", "Error Image Random: ${e.message}")
            }
        }
    }

}

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val repository: AnimeRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}