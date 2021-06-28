package com.example.moorite.ui.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.moorite.R
import com.example.moorite.data.source.local.entity.MovieEntity
import com.example.moorite.databinding.ActivityDetailMovieBinding
import com.example.moorite.viewmodel.ViewModelFactory
import com.example.moorite.vo.Status

class DetailMovieActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailMovieBinding
    private lateinit var viewModel: DetailMovieViewModel
    private var menu: Menu? = null

    companion object {
        const val EXTRA_MOVIE_ID = "extra_movie_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailMovieViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE_ID)
            if (movieId != null) {

                binding.progressBar.visibility = View.VISIBLE
                viewModel.setSelectedMovie(movieId)

                viewModel.detailMovie.observe(this, { detailMovieResource ->
                    if (detailMovieResource != null) {
                        when (detailMovieResource.status) {
                            Status.LOADING -> binding.progressBar.visibility = View.VISIBLE
                            Status.SUCCESS -> if (detailMovieResource.data != null) {
                                binding.progressBar.visibility = View.GONE
                                setMovie(detailMovieResource.data)
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

    private fun setMovie(movieEntity: MovieEntity){
        binding.txtMovieTitle.text = movieEntity.movieTitle
        binding.txtMovieRelease.text = movieEntity.movieRelease
        binding.txtMovieSynopsis.text = movieEntity.movieSynopsis
        binding.txtMovieScore.text = movieEntity.movieScore.toString()

        val foto = "https://image.tmdb.org/t/p/w342/" + movieEntity.moviePoster
        Glide.with(this)
            .load(foto)
            .apply(RequestOptions().override(300, 600))
            .into(binding.imgMoviePoster)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu = menu
        viewModel.detailMovie.observe(this, { detailMovieResource ->
            if (detailMovieResource != null) {
                when (detailMovieResource.status) {
                    Status.LOADING -> binding.progressBar.visibility = View.VISIBLE
                    Status.SUCCESS -> if (detailMovieResource.data != null) {
                        binding.progressBar.visibility = View.GONE
                        val state = detailMovieResource.data.movieFavorite
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