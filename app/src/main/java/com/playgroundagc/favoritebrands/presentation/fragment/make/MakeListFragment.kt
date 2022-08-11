package com.playgroundagc.favoritebrands.presentation.fragment.make

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.playgroundagc.core.domain.model.Make
import com.playgroundagc.favoritebrands.R
import com.playgroundagc.favoritebrands.databinding.FragmentMakeListBinding
import com.playgroundagc.favoritebrands.framework.FragmentViewModel

class MakeListFragment : Fragment(), MakeAction {

    //region Variables
    private lateinit var binding: FragmentMakeListBinding
    private lateinit var makeAdapter: MakeListAdapter
    private val viewModel: FragmentViewModel by activityViewModels()
    //endregion

    //region Override Methods
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_make_list, container, false)

        setupViews()

        return binding.root
    }

    override fun onClick(make: Make) {
        viewModel.toggleFavorite(make)
        makeAdapter.notifyDataSetChanged()
    }
    //endregion

    //region Setup
    private fun setupViews() {
        setupRecyclerView()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.makeList.observe(viewLifecycleOwner) { makeList ->
            makeAdapter.submitList(makeList)
        }
    }

    private fun setupRecyclerView() {
        makeAdapter = MakeListAdapter(this)
        binding.makeRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.makeRecyclerView.adapter = makeAdapter
    }
    //endregion
}