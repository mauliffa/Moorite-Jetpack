package com.example.moorite.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.moorite.data.source.local.entity.MovieEntity
import com.example.moorite.data.source.local.entity.TVShowEntity
import com.example.moorite.vo.Resource

interface DataSource {

    fun getMovie(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getDetailMovie(movieId: String): LiveData<Resource<MovieEntity>>

    fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>>

    fun deleteMovie(movieId: String)

    fun setFavoriteMovie(movie: MovieEntity, state: Boolean)

    fun getTV(): LiveData<Resource<PagedList<TVShowEntity>>>

    fun getDetailTV(tvId: String): LiveData<Resource<TVShowEntity>>

    fun getFavoriteTV(): LiveData<PagedList<TVShowEntity>>

    fun deleteTV(tvId: String)

    fun setFavoriteTV(tv: TVShowEntity, state: Boolean)

}