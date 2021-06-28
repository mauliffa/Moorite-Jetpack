package com.example.moorite.data.source

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.moorite.data.NetworkBoundResource
import com.example.moorite.data.source.local.LocalDataSource
import com.example.moorite.data.source.local.entity.MovieEntity
import com.example.moorite.data.source.local.entity.TVShowEntity
import com.example.moorite.data.source.remote.ApiResponse
import com.example.moorite.data.source.remote.RemoteDataSource
import com.example.moorite.data.source.remote.response.MovieResponse
import com.example.moorite.data.source.remote.response.TVResponse
import com.example.moorite.utils.AppExecutors
import com.example.moorite.vo.Resource

class FakeRepository constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors)
    : DataSource {

    override fun getMovie(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object : NetworkBoundResource<PagedList<MovieEntity>, List<MovieResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<MovieEntity>>{
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getMovie(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getMovie()

            public override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in data) {
                    val movie = MovieEntity(
                        response.movieId,
                        response.moviePoster,
                        response.movieTitle,
                        response.movieRelease,
                        response.movieSynopsis,
                        response.movieScore
                    )
                    movieList.add(movie)
                }

                localDataSource.insertMovie(movieList)
            }
        }.asLiveData()
    }

    override fun getDetailMovie(movieId: String): LiveData<Resource<MovieEntity>> {
        return object : NetworkBoundResource<MovieEntity, List<MovieResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<MovieEntity> =
                localDataSource.getMovieDetail(movieId)

            override fun shouldFetch(data: MovieEntity?): Boolean =
                data == null

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getMovie()

            override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in data) {
                    val movie = MovieEntity(
                        response.movieId,
                        response.moviePoster,
                        response.movieTitle,
                        response.movieRelease,
                        response.movieSynopsis,
                        response.movieScore
                    )
                    movieList.add(movie)
                }
                localDataSource.insertMovie(movieList)
            }
        }.asLiveData()
    }

    override fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteMovie(), config).build()
    }

    override fun deleteMovie(movieId: String) =
        appExecutors.diskIO().execute { localDataSource.deleteMovie(movieId) }

    override fun setFavoriteMovie(movie: MovieEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setFavoriteMovie(movie, state) }

    override fun getTV(): LiveData<Resource<PagedList<TVShowEntity>>> {
        return object : NetworkBoundResource<PagedList<TVShowEntity>, List<TVResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<TVShowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getTV(), config).build()
            }

            override fun shouldFetch(data: PagedList<TVShowEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<TVResponse>>> =
                remoteDataSource.getTV()

            public override fun saveCallResult(data: List<TVResponse>) {
                val tvList = ArrayList<TVShowEntity>()
                for (response in data) {
                    val tv = TVShowEntity(
                        response.tvId,
                        response.tvPoster,
                        response.tvTitle,
                        response.tvRelease,
                        response.tvSynopsis,
                        response.tvScore
                    )
                    tvList.add(tv)
                }

                localDataSource.insertTV(tvList)
            }
        }.asLiveData()
    }

    override fun getDetailTV(tvId: String): LiveData<Resource<TVShowEntity>> {
        return object : NetworkBoundResource<TVShowEntity, List<TVResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<TVShowEntity> =
                localDataSource.getTVDetail(tvId)

            override fun shouldFetch(data: TVShowEntity?): Boolean =
                data == null

            override fun createCall(): LiveData<ApiResponse<List<TVResponse>>> =
                remoteDataSource.getTV()

            override fun saveCallResult(data: List<TVResponse>) {
                val tvList = ArrayList<TVShowEntity>()
                for (response in data) {
                    val tv = TVShowEntity(
                        response.tvId,
                        response.tvPoster,
                        response.tvTitle,
                        response.tvRelease,
                        response.tvSynopsis,
                        response.tvScore
                    )
                    tvList.add(tv)
                }
                localDataSource.insertTV(tvList)
            }
        }.asLiveData()
    }

    override fun getFavoriteTV(): LiveData<PagedList<TVShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteTV(), config).build()
    }

    override fun deleteTV(tvId: String) {
        appExecutors.diskIO().execute { localDataSource.deleteTV(tvId) }
    }

    override fun setFavoriteTV(tv: TVShowEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setFavoriteTV(tv, state) }

}