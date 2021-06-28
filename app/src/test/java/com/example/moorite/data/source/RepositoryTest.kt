package com.example.moorite.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.moorite.data.source.local.LocalDataSource
import com.example.moorite.data.source.local.entity.MovieEntity
import com.example.moorite.data.source.local.entity.TVShowEntity
import com.example.moorite.data.source.remote.RemoteDataSource
import com.example.moorite.utils.*
import com.example.moorite.vo.Resource
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*


class RepositoryTest{

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)
    private val testExecutors = AppExecutors(TestExecutor(), TestExecutor(), TestExecutor())

    private val repository = FakeRepository(remote, local, appExecutors)

    private val movieResponses = DataDummy.generateDummyMovies()
    private val movieId = movieResponses[0].movieId
    private val tvResponses = DataDummy.generateDummyTV()
    private val tvId = tvResponses[0].tvId

    @Test
    fun getMovie() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getMovie()).thenReturn(dataSourceFactory)
        repository.getMovie()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getMovie()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getDetailMovie() {
        val dummyEntity = MutableLiveData<MovieEntity>()
        dummyEntity.value = movieResponses[0]
        `when`(local.getMovieDetail(movieId)).thenReturn(dummyEntity)

        val movieEntities = LiveDataTestUtil.getValue(repository.getDetailMovie(movieId))
        verify(local).getMovieDetail(movieId)

        assertNotNull(movieEntities)
        assertNotNull(movieEntities.data)
        assertNotNull(movieEntities.data?.movieTitle)
        assertEquals(movieResponses[0].movieTitle, movieEntities.data?.movieTitle)
        assertNotNull(movieEntities.data?.moviePoster)
        assertEquals(movieResponses[0].moviePoster, movieEntities.data?.moviePoster)
        assertNotNull(movieEntities.data?.movieRelease)
        assertEquals(movieResponses[0].movieRelease, movieEntities.data?.movieRelease)
        assertNotNull(movieEntities.data?.movieSynopsis)
        assertEquals(movieResponses[0].movieSynopsis, movieEntities.data?.movieSynopsis)
        assertNotNull(movieEntities.data?.movieScore)
        assertEquals(movieResponses[0].movieScore, movieEntities.data?.movieScore)
    }

    @Test
    fun getFavoriteMovie() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getFavoriteMovie()).thenReturn(dataSourceFactory)
        repository.getFavoriteMovie()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getFavoriteMovie()
        assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun setFavoriteMovie() {
        val dummy = DataDummy.generateDummyMovies()[0]
        val newState = !dummy.movieFavorite

        `when`(appExecutors.diskIO()).thenReturn(testExecutors.diskIO())
        doNothing().`when`(local).setFavoriteMovie(dummy, newState)

        repository.setFavoriteMovie(dummy, newState)
        verify(local, times(1)).setFavoriteMovie(dummy, newState)
    }

    @Test
    fun deleteMovie() {
        `when`(appExecutors.diskIO()).thenReturn(testExecutors.diskIO())
        doNothing().`when`(local).deleteMovie(movieId)

        repository.deleteMovie(movieId)
        verify(local, times(1)).deleteMovie(movieId)
    }

    @Test
    fun getTV() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TVShowEntity>
        `when`(local.getTV()).thenReturn(dataSourceFactory)
        repository.getTV()

        val tvEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTV()))
        verify(local).getTV()
        assertNotNull(tvEntities.data)
        assertEquals(tvResponses.size.toLong(), tvEntities.data?.size?.toLong())
    }

    @Test
    fun getDetailTV() {
        val dummyEntity = MutableLiveData<TVShowEntity>()
        dummyEntity.value = tvResponses[0]
        `when`(local.getTVDetail(tvId)).thenReturn(dummyEntity)

        val tvEntities = LiveDataTestUtil.getValue(repository.getDetailTV(tvId))
        verify(local).getTVDetail(tvId)

        assertNotNull(tvEntities)
        assertNotNull(tvEntities.data)
        assertNotNull(tvEntities.data?.tvTitle)
        assertEquals(tvResponses[0].tvTitle, tvEntities.data?.tvTitle)
        assertNotNull(tvEntities.data?.tvPoster)
        assertEquals(tvResponses[0].tvPoster, tvEntities.data?.tvPoster)
        assertNotNull(tvEntities.data?.tvRelease)
        assertEquals(tvResponses[0].tvRelease, tvEntities.data?.tvRelease)
        assertNotNull(tvEntities.data?.tvSynopsis)
        assertEquals(tvResponses[0].tvSynopsis, tvEntities.data?.tvSynopsis)
        assertNotNull(tvEntities.data?.tvScore)
        assertEquals(tvResponses[0].tvScore, tvEntities.data?.tvScore)
    }

    @Test
    fun getFavoriteTV() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TVShowEntity>
        `when`(local.getFavoriteTV()).thenReturn(dataSourceFactory)
        repository.getFavoriteTV()

        val tvEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTV()))
        verify(local).getFavoriteTV()
        assertNotNull(tvEntities)
        assertEquals(tvResponses.size.toLong(), tvEntities.data?.size?.toLong())
    }

    @Test
    fun setFavoriteTvShow() {
        val dummy = DataDummy.generateDummyTV()[0]
        val newState = !dummy.tvFavorite

        `when`(appExecutors.diskIO()).thenReturn(testExecutors.diskIO())
        doNothing().`when`(local).setFavoriteTV(dummy, newState)

        repository.setFavoriteTV(dummy, newState)
        verify(local, times(1)).setFavoriteTV(dummy, newState)
    }

    @Test
    fun deleteTV() {
        `when`(appExecutors.diskIO()).thenReturn(testExecutors.diskIO())
        doNothing().`when`(local).deleteTV(tvId)

        repository.deleteTV(tvId)
        verify(local, times(1)).deleteTV(tvId)
    }
}