package com.example.myapplication.views

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ListItemBinding
import com.example.myapplication.models.Affirmation

class AdapterAffirmations(private val context: Context, private val dataset: List<Affirmation>)
    : RecyclerView.Adapter<AdapterAffirmations.ItemViewHolder>(){

    class ItemViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(affirmations: Affirmation) {
            binding.affirmation = affirmations
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(layoutInflater, parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount() = dataset.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(dataset[position])
    }
}