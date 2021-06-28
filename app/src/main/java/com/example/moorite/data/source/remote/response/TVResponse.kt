package com.example.moorite.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TVResponse(
    var tvId: String,
    var tvPoster: String,
    var tvTitle: String,
    var tvRelease: String,
    var tvSynopsis: String,
    var tvScore: Double
): Parcelable
