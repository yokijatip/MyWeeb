package eastbound.yokijatiperkasa.myweeb.core.data.source.local

import androidx.lifecycle.LiveData
import eastbound.yokijatiperkasa.myweeb.core.data.source.local.room.AnimeDao

class LocalDataSource private constructor(private val tourismDao: AnimeDao) {

    companion object {
        private var instance: LocalDataSource? = null

        fun getInstance(animeDao: AnimeDao): LocalDataSource =
            instance ?: synchronized(this) {
                instance ?: LocalDataSource(animeDao)
            }
    }

//    fun getAllTourism(): LiveData<List<TourismEntity>> = tourismDao.getAllTourism()
//
//    fun getFavoriteTourism(): LiveData<List<TourismEntity>> = tourismDao.getFavoriteTourism()
//
//    fun insertTourism(tourismList: List<TourismEntity>) = tourismDao.insertTourism(tourismList)
//
//    fun setFavoriteTourism(tourism: TourismEntity, newState: Boolean) {
//        tourism.isFavorite = newState
//        tourismDao.updateFavoriteTourism(tourism)
//    }
}