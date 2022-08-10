package com.playgroundagc.favoritebrands.presentation.fragment.make

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.playgroundagc.core.domain.Make
import com.playgroundagc.favoritebrands.R
import com.playgroundagc.favoritebrands.databinding.FragmentMakeListBinding

class MakeListFragment : Fragment(), MakeAction {

    //region Variables
    private lateinit var binding: FragmentMakeListBinding
    private lateinit var makeAdapter: MakeAdapter
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
        Toast.makeText(requireContext(), "Not yet implemented!", Toast.LENGTH_SHORT).show()
    }
    //endregion

    //region Setup
    private fun setupViews() {
        val brandList = mutableListOf(
            Make("Alfa Romeo"),
            Make("Cadillac"),
            Make("BMW"),
            Make("Ford"),
            Make("Jeep"),
            Make("Fiat"),
            Make("Mazda"),
            Make("Tesla"),
            Make("Audi"),
            Make("Maserati"),
            Make("Mercedes"),
            Make("Citroen"),
            Make("Suzuki"),
            Make("Ram"),
            Make("Volkswagen"),
            Make("Toyota"),
            Make("Alpine"),
            Make("Mini"),
            Make("Ferrari"),
            Make("Saab"),
            Make("Bentley"),
            Make("Chevrolet"),
        )

        setupRecyclerView(brandList)
    }

    private fun setupRecyclerView(makes: MutableList<Make>) {
        makeAdapter = MakeAdapter(this)
        makeAdapter.submitList(makes)

        binding.makeRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.makeRecyclerView.adapter = makeAdapter
    }
    //endregion
}