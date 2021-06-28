package com.example.moorite.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.moorite.data.source.local.entity.MovieEntity
import com.example.moorite.data.source.Repository
import com.example.moorite.vo.Resource

class MovieViewModel (private val repository: Repository) : ViewModel() {
    fun getMovie() : LiveData<Resource<PagedList<MovieEntity>>> = repository.getMovie()
}