package com.example.moorite.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.moorite.data.source.local.entity.MovieEntity
import com.example.moorite.data.source.Repository
import com.example.moorite.utils.DataDummy
import com.example.moorite.vo.Resource
import org.junit.Test
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {
    private lateinit var viewModel: DetailMovieViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val movieId = dummyMovie.movieId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var movieObserver: Observer<Resource<MovieEntity>>

    @Before
    fun setUp(){
        viewModel = DetailMovieViewModel(repository)
        viewModel.setSelectedMovie(movieId)
    }

    @Test
    fun setSelectedMovie() {
        val movieEntities = MutableLiveData<Resource<MovieEntity>>()
        movieEntities.value = Resource.success(dummyMovie)

        `when`(repository.getDetailMovie(movieId)).thenReturn(movieEntities)
        viewModel.setSelectedMovie(movieId)
        viewModel.detailMovie.observeForever(movieObserver)

        verify(movieObserver).onChanged(Resource.success(dummyMovie))
    }

    @Test
    fun addAndDeleteFav() {
        val movieEntities = MutableLiveData<Resource<MovieEntity>>()
        val newState = !dummyMovie.movieFavorite
        movieEntities.value = Resource.success(dummyMovie)

        `when`(repository.getDetailMovie(movieId)).thenReturn(movieEntities)
        doNothing().`when`(repository).setFavoriteMovie(dummyMovie, newState)
        viewModel.detailMovie.observeForever(movieObserver)
        viewModel.addAndDeleteFav()
        verify(repository, times(1)).setFavoriteMovie(dummyMovie, newState)
    }

}