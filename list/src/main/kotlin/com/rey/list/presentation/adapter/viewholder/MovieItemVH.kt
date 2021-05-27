package com.rey.list.presentation.adapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rey.list.databinding.MovieItemBinding
import com.rey.list.presentation.dto.MovieResponseUI
import com.rey.movies.presentation.extension.loadFromUrl

class MovieItemVH(private val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: MovieResponseUI, onClickListener: (id: Int) -> Unit) {
        binding.poster.loadFromUrl(item.poster)
        binding.copyright.text = item.copyright
        binding.root.setOnClickListener {
            onClickListener(item.id)
        }
    }

    companion object {
        fun create(viewGroup: ViewGroup): MovieItemVH {
            val inflater = LayoutInflater.from(viewGroup.context)
            val binding = MovieItemBinding.inflate(inflater, viewGroup, false)
            return MovieItemVH(binding)
        }
    }
}