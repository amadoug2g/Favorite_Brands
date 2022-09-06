package com.playgroundagc.favoritebrands.presentation.fragment.make

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.playgroundagc.core.domain.model.Make
import com.playgroundagc.favoritebrands.R
import com.playgroundagc.favoritebrands.databinding.MakeItemBinding

class MakeViewHolder(private val binding: MakeItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(make: Make, action: MakeAction) {
        with(binding) {
            this.make = make
            makeItemAction.setImageResource(make.favoriteStatus())

            makeItemAction.setOnClickListener {
                if (make.isFavorite) {
                    makeItemAction.setImageResource(R.drawable.ic_round_favorite_border)
                } else {
                    makeItemAction.setImageResource(R.drawable.ic_round_favorite)
                }
                action.onClick(make)
            }
        }
    }

    private fun Make.favoriteStatus(): Int {
        return when (this.isFavorite) {
            true -> R.drawable.ic_round_favorite
            else -> R.drawable.ic_round_favorite_border
        }
    }

    companion object {
        fun from(parent: ViewGroup): MakeViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater.inflate(R.layout.make_item, parent, false)
            val layout = MakeItemBinding.bind(view)
            return MakeViewHolder(layout)
        }
    }
}