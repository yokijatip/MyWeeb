package eastbound.yokijatiperkasa.myweeb.core.data

import eastbound.yokijatiperkasa.myweeb.core.data.source.remote.network.ApiService
import eastbound.yokijatiperkasa.myweeb.core.data.source.remote.respone.AnimeItem

class AnimeRepository(private val apiService: ApiService) {
    suspend fun getTopAnime(): List<AnimeItem> {
        return apiService.getTopAnime().data
    }

    suspend fun getRandomAnime(): AnimeItem {
        return apiService.getRandomAnime().data
    }

}