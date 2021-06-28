package com.example.moorite.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.moorite.data.source.local.entity.TVShowEntity
import com.example.moorite.data.source.Repository
import com.example.moorite.vo.Resource
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
class TVShowViewModelTest {
    private lateinit var viewModel: TVShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<TVShowEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<TVShowEntity>

    @Before
    fun setUp(){
      viewModel = TVShowViewModel(repository)
    }

    @Test
    fun getTV() {
        val dummyTV = Resource.success(pagedList)
        `when`(dummyTV.data?.size).thenReturn(12)
        val tv = MutableLiveData<Resource<PagedList<TVShowEntity>>>()
        tv.value = dummyTV

        `when`(repository.getTV()).thenReturn(tv)
        val tvEntities = viewModel.getTV().value?.data
        verify(repository).getTV()
        assertNotNull(tvEntities)
        assertEquals(12, tvEntities?.size)

        viewModel.getTV().observeForever(observer)
        verify(observer).onChanged(dummyTV)
    }
}