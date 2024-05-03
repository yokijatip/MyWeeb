package eastbound.yokijatiperkasa.myweeb.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "anime")
data class AnimeEntity (
    @PrimaryKey
    @NonNull
    @ColumnInfo("mal_id")
    val mal_id: Int,

    @ColumnInfo("image")
    val images: String,

    @ColumnInfo("title")
    val title: String,

    @ColumnInfo("title_english")
    val title_english: String,

    @ColumnInfo("episodes")
    val episodes: Int,

    @ColumnInfo("score")
    val score: Int,

    @ColumnInfo("rank")
    val rank: Int,

    @ColumnInfo("year")
    val year: Int,

    @ColumnInfo("synopsis")
    val synopsis: String,

    @ColumnInfo("background")
    val background: String,

    @ColumnInfo("isBookmark")
    val isBookmark: Boolean = false

)