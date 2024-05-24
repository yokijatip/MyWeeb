package eastbound.yokijatiperkasa.myweeb.core.data.source.remote.respone

import com.google.gson.annotations.SerializedName

data class AnimeItem(
    val mal_id: Int,

    val url: String,

    val images: Images,

    val title: String,

    val type: String,

    val episodes: Int,

    val status: String,

    val score: Double,

    val synopsis: String
)

data class Images(
    @SerializedName("webp")
    val webp: ImageData,
    val jpg: ImageData
)

data class ImageData(
    @SerializedName("image_url")
    val imageUrl: String
)