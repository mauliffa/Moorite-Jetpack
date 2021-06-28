package com.example.moorite.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import androidx.room.Dao
import com.example.moorite.data.source.local.entity.MovieEntity
import com.example.moorite.data.source.local.entity.TVShowEntity

@Dao
interface Dao {
    @Query("SELECT * FROM movieentities")
    fun getMovie(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movieentities where movieFavorite = 1")
    fun getFavoriteMovie(): DataSource.Factory<Int, MovieEntity>

    @Transaction
    @Query("SELECT * FROM movieentities WHERE movieId = :movieId")
    fun getMovieDetail(movieId: String): LiveData<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movies: List<MovieEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)

    @Query("DELETE FROM movieentities where movieId = :movieId")
    fun deleteMovie (movieId: String)

    @Query("SELECT * FROM tventities")
    fun getTV(): DataSource.Factory<Int, TVShowEntity>

    @Query("SELECT * FROM tventities where tvFavorite = 1")
    fun getFavoriteTV(): DataSource.Factory<Int, TVShowEntity>

    @Transaction
    @Query("SELECT * FROM tventities WHERE tvId = :tvId")
    fun getTVDetail(tvId: String): LiveData<TVShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTV(tv: List<TVShowEntity>)

    @Update
    fun updateTV(tv: TVShowEntity)

    @Query("DELETE FROM tventities where tvId = :tvId")
    fun deleteTV (tvId: String)
}