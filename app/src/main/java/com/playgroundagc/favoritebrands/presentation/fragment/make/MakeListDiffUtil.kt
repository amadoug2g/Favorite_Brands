package com.playgroundagc.favoritebrands.presentation.fragment.make

import androidx.recyclerview.widget.DiffUtil
import com.playgroundagc.core.domain.model.Make

class MakeListDiffUtil(
    private val oldList: List<Make>,
    private val newList: List<Make>,
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].name == newList[newItemPosition].name
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}