package com.example.mealdbapp.mealdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.mealdbapp.databinding.FragmentMealDetailBinding

class MealDetailFragment : Fragment() {

    val args: MealDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMealDetailBinding.inflate(inflater, container, false)
        val factory = MealDetailViewModelFactory(requireContext())
        val viewModel = ViewModelProvider(this, factory).get(MealDetailViewModel::class.java)

        viewModel.meal.observe(viewLifecycleOwner, {
            binding.meal = it
        })

        viewModel.updateMeal(args.id)

        return binding.root
    }

}