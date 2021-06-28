package com.example.moorite.ui.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.moorite.data.source.Repository
import com.example.moorite.data.source.local.entity.MovieEntity
import com.example.moorite.data.source.local.entity.TVShowEntity
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteViewModelTest {
    private lateinit var viewModel: FavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var movObserver: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var tvObserver: Observer<PagedList<TVShowEntity>>

    @Mock
    private lateinit var movPagedList: PagedList<MovieEntity>

    @Mock
    private lateinit var tvPagedList: PagedList<TVShowEntity>

    @Before
    fun setUp() {
        viewModel = FavoriteViewModel(repository)
    }


    @Test
    fun getFavoriteMovie() {
        val dummyMovie = movPagedList
        `when`(dummyMovie.size).thenReturn(12)
        val movies = MutableLiveData<PagedList<MovieEntity>>()
        movies.value = dummyMovie

        `when`(repository.getFavoriteMovie()).thenReturn(movies)
        val movieEntities = viewModel.getFavoriteMovie().value
        verify(repository).getFavoriteMovie()
        assertNotNull(movieEntities)
        assertEquals(12, movieEntities?.size)

        viewModel.getFavoriteMovie().observeForever(movObserver)
        verify(movObserver).onChanged(dummyMovie)
    }

    @Test
    fun getFavoriteTV() {
        val dummyTV = tvPagedList
        `when`(dummyTV.size).thenReturn(12)
        val tv = MutableLiveData<PagedList<TVShowEntity>>()
        tv.value = dummyTV

        `when`(repository.getFavoriteTV()).thenReturn(tv)
        val tvEntities = viewModel.getFavoriteTV().value
        verify(repository).getFavoriteTV()
        assertNotNull(tvEntities)
        assertEquals(12, tvEntities?.size)

        viewModel.getFavoriteTV().observeForever(tvObserver)
        verify(tvObserver).onChanged(dummyTV)
    }

}