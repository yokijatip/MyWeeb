package eastbound.yokijatiperkasa.myweeb.core.data

import eastbound.yokijatiperkasa.myweeb.core.data.source.remote.network.ApiService
import eastbound.yokijatiperkasa.myweeb.core.data.source.remote.respone.AnimeItem
import eastbound.yokijatiperkasa.myweeb.core.domain.repository.IAnimeRepository

class AnimeRepository(private val apiService: ApiService) : IAnimeRepository {
    override suspend fun getTopAnime(): List<AnimeItem> {
        return apiService.getTopAnime().data
    }

}