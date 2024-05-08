package eastbound.yokijatiperkasa.myweeb.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import eastbound.yokijatiperkasa.myweeb.core.data.source.remote.respone.AnimeItem
import eastbound.yokijatiperkasa.myweeb.core.domain.repository.IAnimeRepository
import kotlinx.coroutines.launch

class HomeViewModel(private var animeRepository: IAnimeRepository) : ViewModel() {

    private val _topAnime = MutableLiveData<List<AnimeItem>>()
    val topAnime: LiveData<List<AnimeItem>> get() = _topAnime

    fun fetchTopAnime() {
        viewModelScope.launch {
            _topAnime.value = animeRepository.getTopAnime()
        }
    }

}

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val repository: IAnimeRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}