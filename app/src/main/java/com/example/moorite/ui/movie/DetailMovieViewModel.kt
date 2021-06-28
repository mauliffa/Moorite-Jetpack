package com.example.moorite.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.moorite.data.source.local.entity.MovieEntity
import com.example.moorite.data.source.Repository
import com.example.moorite.vo.Resource

class DetailMovieViewModel (private val repository: Repository): ViewModel() {
    val movieId = MutableLiveData<String>()

    fun setSelectedMovie(movieId: String){
        this.movieId.value = movieId
    }

    var detailMovie: LiveData<Resource<MovieEntity>> = Transformations.switchMap(movieId) { mMovieId ->
        repository.getDetailMovie(mMovieId)
    }

    fun addAndDeleteFav() {
        val resource = detailMovie.value
        if (resource != null) {
            val detail = resource.data
            if (detail != null) {
                val newState = !detail.movieFavorite
                repository.setFavoriteMovie(detail, newState)
            }
        }
    }

}