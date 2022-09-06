package com.playgroundagc.favoritebrands.presentation.fragment.make

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.playgroundagc.core.domain.model.Make

/**
 * Created by Amadou on 10/08/2022
 *
 */

class MakeListAdapter(private var action: MakeAction) : RecyclerView.Adapter<MakeViewHolder>() {

    private var oldList = emptyList<Make>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MakeViewHolder {
        return MakeViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MakeViewHolder, position: Int) {
        holder.bind(oldList[position], action)
    }

    override fun getItemCount(): Int = oldList.size

    fun setData(newList: List<Make>) {
        val diffUtil = MakeListDiffUtil(oldList, newList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        oldList = newList
        diffResult.dispatchUpdatesTo(this)
    }
}