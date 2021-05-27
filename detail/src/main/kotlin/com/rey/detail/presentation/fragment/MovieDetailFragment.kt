package com.rey.detail.presentation.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import com.rey.detail.databinding.FragmentMovieDetailBinding
import com.rey.detail.external.di.DaggerDetailComponent
import com.rey.detail.presentation.viewmodel.MovieDetailViewModel
import com.rey.movies.AndroidApplication.Companion.appComponent
import com.rey.movies.presentation.extension.loadFromUrl
import com.rey.movies.presentation.viewmodel.ViewModelFactory
import javax.inject.Inject

class MovieDetailFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: MovieDetailViewModel by viewModels {
        viewModelFactory
    }

    private lateinit var binding: FragmentMovieDetailBinding

    private val args: MovieDetailFragmentArgs by navArgs()

    override fun onAttach(context: Context) {
        DaggerDetailComponent.factory().create(appComponent(requireContext())).inject(this)
        super.onAttach(context)
    }

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

        viewModel.getMovieDetail(args.id)
        initObservers()
    }

    private fun initObservers() {
        viewModel.detail.observe(viewLifecycleOwner) { detail ->
            with(binding) {
                poster.loadFromUrl(detail.poster)
                title.text = detail.title
                summary.text = detail.summary
            }
        }

        viewModel.error.observe(viewLifecycleOwner) { event ->
            event.getContentIfNotHandled()?.let { msg ->
                Snackbar.make(
                    requireContext(),
                    binding.root,
                    msg,
                    BaseTransientBottomBar.LENGTH_LONG
                ).show()
            }
        }
    }
}