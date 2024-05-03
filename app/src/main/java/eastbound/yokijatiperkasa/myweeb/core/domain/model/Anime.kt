package eastbound.yokijatiperkasa.myweeb.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Anime(
    val mal_id: Int,
    val images: String,
    val title: String,
    val title_english: String,
    val episodes: Int,
    val score: Int,
    val rank: Int,
    val year: Int,
    val synopsis: String,
    val background: String,
    val isBookmark: Boolean
) : Parcelable
