package com.rey.list.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.rey.list.presentation.adapter.diffutil.MovieListAdapterDiffUtil
import com.rey.list.presentation.adapter.viewholder.MovieItemVH
import com.rey.list.presentation.dto.MovieResponseUI


class MovieListAdapter(private val onClickListener: (id: Int) -> Unit) :
    ListAdapter<MovieResponseUI, MovieItemVH>(MovieListAdapterDiffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemVH =
        MovieItemVH.create(parent)

    override fun onBindViewHolder(holder: MovieItemVH, position: Int) =
        holder.bind(getItem(position), onClickListener)
}