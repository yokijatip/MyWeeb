package eastbound.yokijatiperkasa.myweeb.core.data.source.remote.respone

data class AnimeResponse (
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
)