package eastbound.yokijatiperkasa.myweeb.core.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import eastbound.yokijatiperkasa.myweeb.core.data.source.remote.respone.AnimeItem
import eastbound.yokijatiperkasa.myweeb.core.data.source.remote.respone.ImageData
import eastbound.yokijatiperkasa.myweeb.databinding.ItemAnimeTopBinding

class TopAnimeAdapter :
    ListAdapter<AnimeItem, TopAnimeAdapter.AnimeViewHolder>(AnimeDiffCallback()) {
    inner class AnimeViewHolder(private val binding: ItemAnimeTopBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(anime: AnimeItem) {

            binding.apply {

                val imageData: ImageData? = anime.images.webp

                if (imageData != null) {
                    val imageUrl = imageData.imageUrl
                    Glide.with(itemView)
                        .load(imageUrl)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .centerCrop()
                        .into(ivCover)
                }
                tvTitle.text = anime.title
            }
        }

    }

    private class AnimeDiffCallback : DiffUtil.ItemCallback<AnimeItem>() {
        override fun areItemsTheSame(oldItem: AnimeItem, newItem: AnimeItem): Boolean {
            return oldItem.mal_id == newItem.mal_id
        }

        override fun areContentsTheSame(oldItem: AnimeItem, newItem: AnimeItem): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TopAnimeAdapter.AnimeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemAnimeTopBinding.inflate(inflater, parent, false)
        return AnimeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TopAnimeAdapter.AnimeViewHolder, position: Int) {
        val anime = getItem(position)
        holder.bind(anime)
    }


}