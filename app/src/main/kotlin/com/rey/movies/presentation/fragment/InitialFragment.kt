package com.rey.movies.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.rey.movies.databinding.FragmentInitialBinding

class InitialFragment : Fragment() {

    private lateinit var binding: FragmentInitialBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInitialBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        navigateToList()
    }

    private fun navigateToList() {
        val direction = InitialFragmentDirections.actionInitialFragmentToMainActivity()
        findNavController().navigate(direction)
        requireActivity().finish()
    }
}