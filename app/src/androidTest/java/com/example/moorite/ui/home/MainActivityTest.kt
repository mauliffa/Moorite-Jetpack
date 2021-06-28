package com.example.moorite.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.moorite.R
import com.example.moorite.utils.DataDummy
import com.example.moorite.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Test

class MainActivityTest{
    private val dummyMovie = DataDummy.generateDummyMovies()
    private val dummyTV = DataDummy.generateDummyTV()

    @Before
    fun setUp() {
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadMovies(){
        onView(withText("MOVIES")).perform(click())
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))

        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.txtMovieTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.txtMovieTitle)).perform(swipeUp())
        onView(withId(R.id.txtMovieTitle)).check(matches(withText(dummyMovie[0].movieTitle)))

        onView(withId(R.id.txtMovieTitle)).perform(swipeUp())
        onView(withId(R.id.txtMovieRelease)).check(matches(isDisplayed()))
        onView(withId(R.id.txtMovieTitle)).perform(swipeUp())
        onView(withId(R.id.txtMovieRelease)).check(matches(withText(dummyMovie[0].movieRelease)))

        onView(withId(R.id.txtMovieTitle)).perform(swipeUp())
        onView(withId(R.id.txtMovieScore)).check(matches(isDisplayed()))
        onView(withId(R.id.txtMovieTitle)).perform(swipeUp())
        onView(withId(R.id.txtMovieScore)).check(matches(withText(dummyMovie[0].movieScore.toString())))

        onView(withId(R.id.txtMovieTitle)).perform(swipeUp())
        onView(withId(R.id.txtMovieSynopsis)).check(matches(isDisplayed()))
        onView(withId(R.id.txtMovieTitle)).perform(swipeUp())
        onView(withId(R.id.txtMovieSynopsis)).check(matches(withText(dummyMovie[0].movieSynopsis)))
    }

    @Test
    fun loadMovFav(){
        onView(withText("MOVIES")).perform(click())
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.action_fav)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())

        onView(withId(R.id.btn_fav)).perform(click())

        onView(withId(R.id.rv_FavMov)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_FavMov)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.txtMovieTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.txtMovieTitle)).perform(swipeUp())
        onView(withId(R.id.txtMovieTitle)).check(matches(withText(dummyMovie[0].movieTitle)))

        onView(withId(R.id.txtMovieTitle)).perform(swipeUp())
        onView(withId(R.id.txtMovieRelease)).check(matches(isDisplayed()))
        onView(withId(R.id.txtMovieTitle)).perform(swipeUp())
        onView(withId(R.id.txtMovieRelease)).check(matches(withText(dummyMovie[0].movieRelease)))

        onView(withId(R.id.txtMovieTitle)).perform(swipeUp())
        onView(withId(R.id.txtMovieScore)).check(matches(isDisplayed()))
        onView(withId(R.id.txtMovieTitle)).perform(swipeUp())
        onView(withId(R.id.txtMovieScore)).check(matches(withText(dummyMovie[0].movieScore.toString())))

        onView(withId(R.id.txtMovieTitle)).perform(swipeUp())
        onView(withId(R.id.txtMovieSynopsis)).check(matches(isDisplayed()))
        onView(withId(R.id.txtMovieTitle)).perform(swipeUp())
        onView(withId(R.id.txtMovieSynopsis)).check(matches(withText(dummyMovie[0].movieSynopsis)))

        onView(withId(R.id.action_fav)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
    }


    @Test
    fun loadTVShow(){
        onView(withText("TV SHOWS")).perform(click())

        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTV.size))

        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.txtTVTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.txtTVTitle)).perform(swipeUp())
        onView(withId(R.id.txtTVTitle)).check(matches(withText(dummyTV[0].tvTitle)))

        onView(withId(R.id.txtTVTitle)).perform(swipeUp())
        onView(withId(R.id.txtTVRelease)).check(matches(isDisplayed()))
        onView(withId(R.id.txtTVTitle)).perform(swipeUp())
        onView(withId(R.id.txtTVRelease)).check(matches(withText(dummyTV[0].tvRelease)))

        onView(withId(R.id.txtTVTitle)).perform(swipeUp())
        onView(withId(R.id.txtTVScore)).check(matches(isDisplayed()))
        onView(withId(R.id.txtTVTitle)).perform(swipeUp())
        onView(withId(R.id.txtTVScore)).check(matches(withText(dummyTV[0].tvScore.toString())))

        onView(withId(R.id.txtTVTitle)).perform(swipeUp())
        onView(withId(R.id.txtTVSynopsis)).check(matches(isDisplayed()))
        onView(withId(R.id.txtTVTitle)).perform(swipeUp())
        onView(withId(R.id.txtTVSynopsis)).check(matches(withText(dummyTV[0].tvSynopsis)))
    }

    @Test
    fun loadFavTV(){
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.action_fav)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())

        onView(withId(R.id.btn_fav)).perform(click())

        onView(withId(R.id.txtFavTV)).perform(swipeUp())
        onView(withId(R.id.rv_FavTV)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_FavTV)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.txtTVTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.txtTVTitle)).perform(swipeUp())
        onView(withId(R.id.txtTVTitle)).check(matches(withText(dummyTV[0].tvTitle)))

        onView(withId(R.id.txtTVTitle)).perform(swipeUp())
        onView(withId(R.id.txtTVRelease)).check(matches(isDisplayed()))
        onView(withId(R.id.txtTVTitle)).perform(swipeUp())
        onView(withId(R.id.txtTVRelease)).check(matches(withText(dummyTV[0].tvRelease)))

        onView(withId(R.id.txtTVTitle)).perform(swipeUp())
        onView(withId(R.id.txtTVScore)).check(matches(isDisplayed()))
        onView(withId(R.id.txtTVTitle)).perform(swipeUp())
        onView(withId(R.id.txtTVScore)).check(matches(withText(dummyTV[0].tvScore.toString())))

        onView(withId(R.id.txtTVTitle)).perform(swipeUp())
        onView(withId(R.id.txtTVSynopsis)).check(matches(isDisplayed()))
        onView(withId(R.id.txtTVTitle)).perform(swipeUp())
        onView(withId(R.id.txtTVSynopsis)).check(matches(withText(dummyTV[0].tvSynopsis)))

        onView(withId(R.id.action_fav)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
    }

}