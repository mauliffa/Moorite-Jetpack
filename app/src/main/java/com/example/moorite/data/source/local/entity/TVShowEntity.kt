package com.example.moorite.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tventities")
data class TVShowEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "tvId")
    var tvId: String,

    @ColumnInfo(name = "tvPoster")
    var tvPoster: String,

    @ColumnInfo(name = "tvTitle")
    var tvTitle: String,

    @ColumnInfo(name = "tvRelease")
    var tvRelease: String,

    @ColumnInfo(name = "tvSynopsis")
    var tvSynopsis: String,

    @ColumnInfo(name = "tvScore")
    var tvScore: Double,

    @ColumnInfo(name = "tvFavorite")
    var tvFavorite: Boolean = false,
)
