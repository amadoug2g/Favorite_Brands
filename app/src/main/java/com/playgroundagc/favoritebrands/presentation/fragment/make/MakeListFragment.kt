package com.playgroundagc.favoritebrands.presentation.fragment.make

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.playgroundagc.favoritebrands.R
import com.playgroundagc.favoritebrands.databinding.FragmentMakeListBinding

class MakeListFragment : Fragment() {

    //region Variables
    private lateinit var binding: FragmentMakeListBinding
    //endregion

    //region Override Methods
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_make_list, container, false)

        return binding.root
    }
    //endregion
}