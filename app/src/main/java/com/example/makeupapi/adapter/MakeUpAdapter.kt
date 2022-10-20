package com.example.makeupapi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.makeupapi.databinding.ListItemBinding
import com.example.makeupapi.model.MakeUpItem

class MakeUpAdapter(val listdata : MutableList<MakeUpItem>):RecyclerView.Adapter<MakeUpAdapter.MakeUpViewHolder>() {

    inner class MakeUpViewHolder(val binding : ListItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MakeUpViewHolder {
        return MakeUpViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MakeUpViewHolder, position: Int) {
        holder.binding.apply {
            val data = listdata[position]
            tvname.text = data.name
            tvBrand.text = data.brand
            tvPrice.text = data.price
            Glide.with(root.context).load(data.imageLink).centerCrop().into(img)
        }
    }

    override fun getItemCount(): Int  = listdata.size
}