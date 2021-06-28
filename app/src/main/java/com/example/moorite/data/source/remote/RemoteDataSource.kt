package com.example.moorite.data.source.remote

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moorite.data.source.remote.response.MovieResponse
import com.example.moorite.data.source.remote.response.TVResponse
import com.example.moorite.utils.EspressoIdlingResource
import com.example.moorite.utils.JsonHelper

class RemoteDataSource  private constructor(private val jsonHelper: JsonHelper) {

    private val handler = Handler(Looper.getMainLooper())

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper).apply { instance = this }
            }
    }

    fun getMovie(): LiveData<ApiResponse<List<MovieResponse>>>{
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        handler.postDelayed({
            resultMovie.value = ApiResponse.success(jsonHelper.loadMovies())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultMovie
    }

    fun getTV(): LiveData<ApiResponse<List<TVResponse>>>{
        EspressoIdlingResource.increment()
        val resultTV = MutableLiveData<ApiResponse<List<TVResponse>>>()
        handler.postDelayed({
            resultTV.value = ApiResponse.success(jsonHelper.loadTV())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultTV
    }

}