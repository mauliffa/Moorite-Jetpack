package com.example.moorite.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.moorite.data.source.local.entity.TVShowEntity
import com.example.moorite.data.source.Repository
import com.example.moorite.utils.DataDummy
import com.example.moorite.vo.Resource
import com.example.moorite.vo.Resource.Companion.success
import org.junit.Test

import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailTVShowViewModelTest {
    private lateinit var viewModel: DetailTVShowViewModel
    private val dummyTV = DataDummy.generateDummyTV()[0]
    private val tvId = dummyTV.tvId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var tvObserver: Observer<Resource<TVShowEntity>>

    @Before
    fun setUp() {
        viewModel = DetailTVShowViewModel(repository)
        viewModel.setSelectedTV(tvId)
    }

    @Test
    fun setSelectedTV() {
        val tvEntities = MutableLiveData<Resource<TVShowEntity>>()
        tvEntities.value = success(dummyTV)

        `when`(repository.getDetailTV(tvId)).thenReturn(tvEntities)

        viewModel.setSelectedTV(tvId)
        viewModel.detailTV.observeForever(tvObserver)

        verify(tvObserver).onChanged(success(dummyTV))
    }

    @Test
    fun addAndDeleteFav() {
        val tvEntities = MutableLiveData<Resource<TVShowEntity>>()
        val newState = !dummyTV.tvFavorite
        tvEntities.value = success(dummyTV)

        `when`(repository.getDetailTV(tvId)).thenReturn(tvEntities)
        Mockito.doNothing().`when`(repository).setFavoriteTV(dummyTV, newState)
        viewModel.detailTV.observeForever(tvObserver)
        viewModel.addAndDeleteFav()
        verify(repository, Mockito.times(1)).setFavoriteTV(dummyTV, newState)
    }
}