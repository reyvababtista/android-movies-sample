package com.rey.detail.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.rey.detail.databinding.FragmentMovieDetailBinding
import javax.inject.Inject

class MovieDetailFragment : Fragment() {

    @Inject
    lateinit var viewModelProvider: ViewModelProvider

    private val viewModel:

            private lateinit var binding: FragmentMovieDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        return (binding.root)
    }

    override fun onStart() {
        super.onStart()


    }
}