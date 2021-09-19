package com.example.retrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.databinding.ItemItemBinding

class MusicAdapter(val data: List<Track>) : RecyclerView.Adapter<MusicAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(data: Track, position: Int){
            binding.viewModel = data
            binding.numberText.text = (position+1).toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding:ItemItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.item_item,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(data[position] ,position)
    }

    override fun getItemCount(): Int = data.size
}