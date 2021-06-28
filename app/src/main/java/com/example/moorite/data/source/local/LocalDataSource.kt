package com.example.moorite.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.example.moorite.data.source.local.entity.MovieEntity
import com.example.moorite.data.source.local.entity.TVShowEntity
import com.example.moorite.data.source.local.room.Dao

class LocalDataSource private constructor(private val mDao: Dao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(dao: Dao): LocalDataSource =
            INSTANCE ?: LocalDataSource(dao)
    }

    fun getMovie(): DataSource.Factory<Int, MovieEntity> = mDao.getMovie()

    fun getMovieDetail(movieId: String): LiveData<MovieEntity> =
        mDao.getMovieDetail(movieId)

    fun insertMovie(movies: List<MovieEntity>) = mDao.insertMovie(movies)

    fun getFavoriteMovie(): DataSource.Factory<Int, MovieEntity> = mDao.getFavoriteMovie()

    fun setFavoriteMovie(movie: MovieEntity, newState: Boolean) {
        movie.movieFavorite = newState
        mDao.updateMovie(movie)
    }

    fun deleteMovie(movieId: String){
        mDao.deleteMovie(movieId)
    }

    fun getTV(): DataSource.Factory<Int, TVShowEntity> = mDao.getTV()

    fun getTVDetail(tvId: String): LiveData<TVShowEntity> =
        mDao.getTVDetail(tvId)

    fun insertTV(tv: List<TVShowEntity>) = mDao.insertTV(tv)

    fun getFavoriteTV(): DataSource.Factory<Int, TVShowEntity> = mDao.getFavoriteTV()

    fun setFavoriteTV(tv: TVShowEntity, newState: Boolean) {
        tv.tvFavorite = newState
        mDao.updateTV(tv)
    }

    fun deleteTV(tvId: String){
        mDao.deleteTV(tvId)
    }

}