package com.playgroundagc.favoritebrands.presentation.fragment.make

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.playgroundagc.core.domain.Make

/**
 * Created by Amadou on 10/08/2022
 *
 */

class MakeAdapter(private var action: MakeAction): ListAdapter<Make, MakeViewHolder>(ListDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MakeViewHolder {
        return MakeViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MakeViewHolder, position: Int) {
        holder.bind(getItem(position), action)
    }
}

class ListDiffUtil: DiffUtil.ItemCallback<Make>() {
    override fun areItemsTheSame(oldItem: Make, newItem: Make): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Make, newItem: Make): Boolean {
        return oldItem == newItem
    }
}