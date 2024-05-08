package eastbound.yokijatiperkasa.myweeb.di

import eastbound.yokijatiperkasa.myweeb.core.data.AnimeRepository
import eastbound.yokijatiperkasa.myweeb.core.data.source.remote.network.ApiConfig

object MyInjection {

    fun provideRepository(): AnimeRepository {
        val apiService = ApiConfig.getApiService()
        return AnimeRepository(apiService)
    }

}