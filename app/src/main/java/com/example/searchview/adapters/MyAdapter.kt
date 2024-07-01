package com.example.searchview.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.searchview.databinding.ItemRvBinding
import com.example.searchview.models.User

class MyAdapter(val list: ArrayList<User>): RecyclerView.Adapter<MyAdapter.VH>() {
    inner class VH(val itemRvBinding: ItemRvBinding):RecyclerView.ViewHolder(itemRvBinding.root){
        fun OnBind(user: User){
            itemRvBinding.name.text = user.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.OnBind(list[position])
    }

}