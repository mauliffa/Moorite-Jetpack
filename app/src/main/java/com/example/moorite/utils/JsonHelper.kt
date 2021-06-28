package com.example.moorite.utils

import android.content.Context
import com.example.moorite.data.source.remote.response.MovieResponse
import com.example.moorite.data.source.remote.response.TVResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper (private val context: Context){

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovies(): List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("MovieResponses.json").toString())
            val listArray = responseObject.getJSONArray("results")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val id = movie.getString("id")
                val poster = movie.getString("poster_path")
                val title = movie.getString("title")
                val release = movie.getString("release_date")
                val synopsis = movie.getString("overview")
                val score = movie.getDouble("vote_average")

                val movieResponse = MovieResponse(id, poster, title, release, synopsis, score)
                list.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }

    fun loadTV(): List<TVResponse> {
        val list = ArrayList<TVResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("TVShowResponses.json").toString())
            val listArray = responseObject.getJSONArray("results")
            for (i in 0 until listArray.length()) {
                val tv = listArray.getJSONObject(i)

                val id = tv.getString("id")
                val poster = tv.getString("poster_path")
                val title = tv.getString("name")
                val release = tv.getString("first_air_date")
                val synopsis = tv.getString("overview")
                val score = tv.getDouble("vote_average")

                val tvResponse = TVResponse(id, poster, title, release, synopsis, score)
                list.add(tvResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }
}