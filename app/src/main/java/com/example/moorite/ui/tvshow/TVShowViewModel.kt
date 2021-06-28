package com.example.moorite.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.moorite.data.source.local.entity.TVShowEntity
import com.example.moorite.data.source.Repository
import com.example.moorite.vo.Resource

class TVShowViewModel (private val repository: Repository) : ViewModel() {
    fun getTV(): LiveData<Resource<PagedList<TVShowEntity>>> = repository.getTV()
}