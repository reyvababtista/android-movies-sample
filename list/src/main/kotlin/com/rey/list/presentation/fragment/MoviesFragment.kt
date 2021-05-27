package com.rey.list.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.rey.list.presentation.viewmodel.MovieViewModel

class MoviesFragment : Fragment() {

    lateinit var viewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initObservers()
    }

    private fun initObservers() {

    }
}