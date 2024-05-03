package eastbound.yokijatiperkasa.myweeb.core.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import eastbound.yokijatiperkasa.myweeb.core.data.source.local.entity.AnimeEntity

@Dao
interface AnimeDao {

    @Query("SELECT * FROM anime")
    fun getAllAnime(): LiveData<List<AnimeEntity>>

    @Query("SELECT * FROM anime where isBookmark = 1")
    fun getFavoriteAnime(): LiveData<List<AnimeEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAnime(anime: List<AnimeEntity>)

    @Update
    fun updateFavoriteAnime(anime: AnimeEntity)
}
