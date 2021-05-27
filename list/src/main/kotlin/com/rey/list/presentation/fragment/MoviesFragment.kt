package com.rey.list.presentation.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import com.rey.list.databinding.FragmentMoviesBinding
import com.rey.list.presentation.activity.MainActivity
import com.rey.list.presentation.adapter.MovieListAdapter
import com.rey.list.presentation.viewmodel.MovieViewModel
import com.rey.movies.presentation.viewmodel.ViewModelFactory
import javax.inject.Inject

class MoviesFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: MovieViewModel by activityViewModels {
        viewModelFactory
    }

    private lateinit var binding: FragmentMoviesBinding
    private lateinit var adapter: MovieListAdapter

    override fun onAttach(context: Context) {
        (activity as MainActivity).component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        viewModel.getMovies()
        initObservers()
        initRecyclerView()
    }

    private fun initObservers() {
        viewModel.movies.observe(viewLifecycleOwner) {
            adapter.submitList(it)
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

    private fun initRecyclerView() {
        adapter = MovieListAdapter { id ->
            val direction = MoviesFragmentDirections.actionMoviesFragmentToDetailGraph(id)
            findNavController().navigate(direction)
        }
        binding.list.adapter = adapter
        binding.list.layoutManager =
            StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
    }
}