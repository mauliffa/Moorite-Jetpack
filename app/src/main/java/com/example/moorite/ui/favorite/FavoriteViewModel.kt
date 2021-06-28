package com.example.moorite.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.moorite.data.source.Repository
import com.example.moorite.data.source.local.entity.MovieEntity
import com.example.moorite.data.source.local.entity.TVShowEntity

class FavoriteViewModel (private val repository: Repository) : ViewModel(){

    fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>> = repository.getFavoriteMovie()

    fun setFavoriteMovie(movieEntity: MovieEntity) {
        val newState = !movieEntity.movieFavorite
        repository.setFavoriteMovie(movieEntity, newState)
    }

    fun getFavoriteTV(): LiveData<PagedList<TVShowEntity>> = repository.getFavoriteTV()

    fun setFavoriteTV(tvEntity: TVShowEntity) {
        val newState = !tvEntity.tvFavorite
        repository.setFavoriteTV(tvEntity, newState)
    }
}