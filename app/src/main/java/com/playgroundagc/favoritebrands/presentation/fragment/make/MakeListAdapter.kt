package com.playgroundagc.favoritebrands.presentation.fragment.make

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.playgroundagc.core.domain.model.Make

/**
 * Created by Amadou on 10/08/2022
 *
 */

class MakeListAdapter(private var action: MakeAction): ListAdapter<Make, MakeViewHolder>(MakeListDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MakeViewHolder {
        return MakeViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MakeViewHolder, position: Int) {
        holder.bind(getItem(position), action)
    }
}