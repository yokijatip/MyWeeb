package eastbound.yokijatiperkasa.myweeb.core.data.source.remote.network

import eastbound.yokijatiperkasa.myweeb.core.data.source.remote.respone.TopAnimeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top/anime")
    suspend fun getTopAnime(): TopAnimeResponse


}