package com.rey.list.presentation.adapter.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.rey.list.presentation.dto.MovieResponseUI

object MovieListAdapterDiffUtil : DiffUtil.ItemCallback<MovieResponseUI>() {
    override fun areItemsTheSame(oldItem: MovieResponseUI, newItem: MovieResponseUI): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: MovieResponseUI, newItem: MovieResponseUI): Boolean =
        oldItem == newItem
}