package com.example.mealdbapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mealdbapp.databinding.ListItemMealBinding
import com.example.mealdbapp.models.Meal

class MealAdapter(private var mealClickListener: MealClickListener): ListAdapter<Meal, MealViewHolder>(MealDiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        return MealViewHolder(ListItemMealBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        val meal = getItem(position)
        holder.bindData(meal)
        holder.itemView.setOnClickListener {
            mealClickListener.onMealClicked(meal)
        }
    }

}
private class MealDiffCallBack: DiffUtil.ItemCallback<Meal>(){
    override fun areItemsTheSame(oldItem: Meal, newItem: Meal): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Meal, newItem: Meal): Boolean {
        return oldItem.instructions == newItem.instructions
    }

}

class MealViewHolder(val binding: ListItemMealBinding): RecyclerView.ViewHolder(binding.root){
    fun bindData(meal: Meal){
        binding.meal = meal
    }
}

interface MealClickListener{
    fun onMealClicked(meal: Meal)
}