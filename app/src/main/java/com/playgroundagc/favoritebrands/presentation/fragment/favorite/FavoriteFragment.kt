package com.playgroundagc.favoritebrands.presentation.fragment.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.playgroundagc.favoritebrands.R
import com.playgroundagc.favoritebrands.databinding.FragmentFavoriteBinding
import com.playgroundagc.favoritebrands.framework.FragmentViewModel

class FavoriteFragment : Fragment() {

    //region Variable
    private lateinit var binding: FragmentFavoriteBinding
    private val viewModel: FragmentViewModel by activityViewModels()
    //endregion

    //region Override Methods
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favorite, container, false)

        setupViews()

        return binding.root
    }
    //endregion

    //region Setup
    private fun setupViews() {
        binding.viewModel = viewModel

        binding.apply {
            makeListBtn.setOnClickListener {
                navigateToMakeList()
            }
        }
    }
    //endregion

    //region Navigation
    private fun navigateToMakeList() {
        Navigation
            .findNavController(binding.makeCountTextView)
            .navigate(R.id.favoriteToMakeList)
    }
    //endregion
}