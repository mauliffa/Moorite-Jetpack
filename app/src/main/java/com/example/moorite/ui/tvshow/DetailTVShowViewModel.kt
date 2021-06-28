package com.example.moorite.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.moorite.data.source.local.entity.TVShowEntity
import com.example.moorite.data.source.Repository
import com.example.moorite.vo.Resource

class DetailTVShowViewModel (private val repository: Repository): ViewModel() {
    val tvId = MutableLiveData<String>()

    fun setSelectedTV(tvId: String){
        this.tvId.value = tvId
    }

    var detailTV: LiveData<Resource<TVShowEntity>> = Transformations.switchMap(tvId) { mTVId ->
        repository.getDetailTV(mTVId)
    }

    fun addAndDeleteFav() {
        val resource = detailTV.value
        if (resource != null) {
            val detail = resource.data
            if (detail != null) {
                val newState = !detail.tvFavorite
                repository.setFavoriteTV(detail, newState)
            }
        }
    }

}