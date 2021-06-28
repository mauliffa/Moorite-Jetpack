package com.example.moorite.ui.favorite

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.moorite.data.source.local.entity.TVShowEntity
import com.example.moorite.databinding.ItemFavBinding
import com.example.moorite.ui.tvshow.DetailTVShowActivity

class TVFavAdapter: PagedListAdapter<TVShowEntity, TVFavAdapter.FavTVShowViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TVShowEntity>() {
            override fun areItemsTheSame(oldItem: TVShowEntity, newItem: TVShowEntity): Boolean {
                return oldItem.tvId == newItem.tvId
            }
            override fun areContentsTheSame(oldItem: TVShowEntity, newItem: TVShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavTVShowViewHolder {
        val itemsFavBinding = ItemFavBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavTVShowViewHolder(itemsFavBinding)
    }

    override fun onBindViewHolder(holder: FavTVShowViewHolder, position: Int) {
        val tv = getItem(position)
        if (tv!=null) {
            holder.bind(tv)
        }
    }

    fun getSwipedData(swipedPosition: Int): TVShowEntity? = getItem(swipedPosition)

    inner class FavTVShowViewHolder (private val binding: ItemFavBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tv: TVShowEntity) {
            with(binding) {
                txtFavTitle.text = tv.tvTitle

                val foto = "https://image.tmdb.org/t/p/w342/" + tv.tvPoster
                Glide.with(itemView.context)
                    .load(foto)
                    .apply(RequestOptions.overrideOf(200, 400))
                    .into(binding.imgFavPoster)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailTVShowActivity::class.java)
                    intent.putExtra(DetailTVShowActivity.EXTRA_TVSHOW_ID, tv.tvId)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}