package com.example.mealdbapp.mealoverview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mealdbapp.adapters.MealAdapter
import com.example.mealdbapp.adapters.MealClickListener
import com.example.mealdbapp.data.remote.MealApi
import com.example.mealdbapp.databinding.FragmentMealOverviewBinding
import com.example.mealdbapp.models.Meal

class MealOverviewFragment : Fragment(), MealClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMealOverviewBinding.inflate(inflater, container, false)
        val factory = MealOverviewViewModelFactory(MealApi.retrofitService, requireContext())
        val viewModel = ViewModelProvider(this, factory).get(MealOverviewViewModel::class.java)

        binding.lifecycleOwner = viewLifecycleOwner

        val adapter = MealAdapter(this)
        binding.adapter = adapter

        viewModel.meals.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })

        return binding.root
    }

    override fun onMealClicked(meal: Meal) {
        val directions = MealOverviewFragmentDirections.actionMealOverviewFragmentToMealDetailFragment(meal.id)
        findNavController().navigate(directions)
    }

}