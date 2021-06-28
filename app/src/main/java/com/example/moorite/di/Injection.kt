package com.example.moorite.di

import android.content.Context
import com.example.moorite.data.source.Repository
import com.example.moorite.data.source.local.LocalDataSource
import com.example.moorite.data.source.local.room.MyDatabase
import com.example.moorite.data.source.remote.RemoteDataSource
import com.example.moorite.utils.AppExecutors
import com.example.moorite.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): Repository {

        val database = MyDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.dao())
        val appExecutors = AppExecutors()

        return Repository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}