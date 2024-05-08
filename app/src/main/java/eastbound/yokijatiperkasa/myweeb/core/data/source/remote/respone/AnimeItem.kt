package eastbound.yokijatiperkasa.myweeb.core.data.source.remote.respone

data class AnimeItem(
    val mal_id: Int,
    val url: String,
    val imageUrl: String,
    val title: String,
    val type: String,
    val episodes: Int,
    val status: String,
    val score: Double,
    val synopsis: String
)
