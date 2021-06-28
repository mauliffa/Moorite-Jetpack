package com.example.moorite.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieResponse(
    var movieId: String,
    var moviePoster: String,
    var movieTitle: String,
    var movieRelease: String,
    var movieSynopsis: String,
    var movieScore: Double
): Parcelable
