package com.example.moorite.ui.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moorite.R
import com.example.moorite.databinding.ActivityFavoriteBinding
import com.example.moorite.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

class FavoriteActivity : AppCompatActivity() {
    lateinit var binding: ActivityFavoriteBinding
    private lateinit var viewModel: FavoriteViewModel
    private lateinit var movAdapter: MovFavAdapter
    private lateinit var tvAdapter: TVFavAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        itemTouchHelperMovie.attachToRecyclerView(binding.rvFavMov)
        itemTouchHelperTV.attachToRecyclerView(binding.rvFavTV)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]
        movAdapter = MovFavAdapter()
        tvAdapter = TVFavAdapter()

        binding.progressBar.visibility = View.VISIBLE

        viewModel.getFavoriteMovie().observe(this, { movies ->
            binding.progressBar.visibility = View.GONE
            movAdapter.submitList(movies)
            if(movies.isEmpty()) {
                val text = getString(R.string.you_don_t_have_any_favorite_movie)
                binding.emptyMovFav.text = text
                binding.emptyMovFav.visibility = View.VISIBLE
            }  else {
                binding.emptyMovFav.visibility = View.GONE
            }
        })
        with(binding.rvFavMov) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            this.adapter = movAdapter
        }

        viewModel.getFavoriteTV().observe(this, { tv ->
            binding.progressBar.visibility = View.GONE
            tvAdapter.submitList(tv)
            if(tv.isEmpty()) {
                val text = getString(R.string.you_don_t_have_any_favorite_tv_show)
                binding.emptyTVFav.text = text
                binding.emptyTVFav.visibility = View.VISIBLE
            } else {
                binding.emptyTVFav.visibility = View.GONE
            }
        })
        with(binding.rvFavTV) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            this.adapter = tvAdapter
        }
    }

    private val itemTouchHelperMovie = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(rv: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int =
            makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)

        override fun onMove(rv: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val swipedPosition = viewHolder.adapterPosition

            val movieEntity = movAdapter.getSwipedData(swipedPosition)
            movieEntity?.let { viewModel.setFavoriteMovie(it) }

            val snackbar = Snackbar.make(findViewById(R.id.rv_FavMov), R.string.message_undo, Snackbar.LENGTH_LONG)
            snackbar.setAction(R.string.message_ok) { _ ->
                movieEntity?.let { viewModel.setFavoriteMovie(it) }
            }
            snackbar.show()
        }
    })

    private val itemTouchHelperTV = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(rv: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int =
            makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)

        override fun onMove(rv: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val swipedPosition = viewHolder.adapterPosition

            val tvEntity = tvAdapter.getSwipedData(swipedPosition)
            tvEntity?.let { viewModel.setFavoriteTV(it) }

            val snackbar = Snackbar.make(findViewById(R.id.rv_FavTV), R.string.message_undo, Snackbar.LENGTH_LONG)
            snackbar.setAction(R.string.message_ok) { _ ->
                tvEntity?.let { viewModel.setFavoriteTV(it) }
            }
            snackbar.show()
        }
    })
}