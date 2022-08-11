package com.playgroundagc.favoritebrands.presentation.fragment.make

import androidx.recyclerview.widget.DiffUtil
import com.playgroundagc.core.domain.model.Make

class MakeListDiffUtil: DiffUtil.ItemCallback<Make>() {
    override fun areItemsTheSame(oldItem: Make, newItem: Make): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Make, newItem: Make): Boolean {
        return oldItem == newItem
    }
}