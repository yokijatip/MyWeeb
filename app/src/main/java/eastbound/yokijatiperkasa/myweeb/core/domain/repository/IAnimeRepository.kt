package eastbound.yokijatiperkasa.myweeb.core.domain.repository

import eastbound.yokijatiperkasa.myweeb.core.data.source.remote.respone.AnimeItem

interface IAnimeRepository {
    suspend fun getTopAnime(): List<AnimeItem>
}