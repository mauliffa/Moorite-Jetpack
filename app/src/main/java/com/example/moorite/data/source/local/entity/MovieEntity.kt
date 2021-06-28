package com.example.moorite.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movieentities")
data class MovieEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name="movieId")
    var movieId: String,

    @ColumnInfo(name="moviePoster")
    var moviePoster: String,

    @ColumnInfo(name="movieTitle")
    var movieTitle: String,

    @ColumnInfo(name="movieRelease")
    var movieRelease: String,

    @ColumnInfo(name="movieSynopsis")
    var movieSynopsis: String,

    @ColumnInfo(name="movieScore")
    var movieScore: Double,

    @ColumnInfo(name = "movieFavorite")
    var movieFavorite: Boolean = false,
)
