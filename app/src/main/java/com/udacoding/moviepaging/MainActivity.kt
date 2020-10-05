package com.udacoding.moviepaging

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.udacoding.moviepaging.adapter.MoviesAdapter
import com.udacoding.moviepaging.viewModel.MoviesViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var viewModel: MoviesViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MoviesViewModel::class.java)

        viewModel?.getResult()?.observe(this, Observer {
            val adapter = MoviesAdapter()
            adapter.submitList(it)
            rv_movies.adapter = adapter

        })
    }
}