package com.example.moorite.ui.tvshow

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.moorite.R
import com.example.moorite.data.source.local.entity.TVShowEntity
import com.example.moorite.databinding.ActivityDetailTvShowBinding
import com.example.moorite.viewmodel.ViewModelFactory
import com.example.moorite.vo.Status

class DetailTVShowActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailTvShowBinding
    private lateinit var viewModel: DetailTVShowViewModel
    private var menu: Menu? = null

    companion object {
        const val EXTRA_TVSHOW_ID = "extra_tvshow_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailTVShowViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val tvShowId = extras.getString(EXTRA_TVSHOW_ID)
            if (tvShowId != null) {

                binding.progressBar.visibility = View.VISIBLE
                viewModel.setSelectedTV(tvShowId)

                viewModel.detailTV.observe(this, { detailTVResource ->
                    if (detailTVResource != null) {
                        when (detailTVResource.status) {
                            Status.LOADING -> binding.progressBar.visibility = View.VISIBLE
                            Status.SUCCESS -> if (detailTVResource.data != null) {
                                binding.progressBar.visibility = View.GONE
                                setTV(detailTVResource.data)
                            }
                            Status.ERROR -> {
                                binding.progressBar.visibility = View.GONE
                                Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                })
            }
        }
    }

    private fun setTV(tvShowEntity: TVShowEntity){
        binding.txtTVTitle.text = tvShowEntity.tvTitle
        binding.txtTVRelease.text = tvShowEntity.tvRelease
        binding.txtTVSynopsis.text = tvShowEntity.tvSynopsis
        binding.txtTVScore.text = tvShowEntity.tvScore.toString()

        val foto = "https://image.tmdb.org/t/p/w342/" + tvShowEntity.tvPoster
        Glide.with(this)
            .load(foto)
            .apply(RequestOptions().override(300, 600))
            .into(binding.imgTVPoster)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu = menu
        viewModel.detailTV.observe(this, { detailTVResource ->
            if (detailTVResource != null) {
                when (detailTVResource.status) {
                    Status.LOADING -> binding.progressBar.visibility = View.VISIBLE
                    Status.SUCCESS -> if (detailTVResource.data != null) {
                        binding.progressBar.visibility = View.GONE
                        val state = detailTVResource.data.tvFavorite
                        setFavoriteState(state)
                    }
                    Status.ERROR -> {
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_fav) {
            viewModel.addAndDeleteFav()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    private fun setFavoriteState(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.action_fav)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_unfavorite)
        }
    }
}