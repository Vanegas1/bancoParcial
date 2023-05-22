package com.vanegas1.bancotracker.ui.banco.home.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vanegas1.bancotracker.data.model.BancoModel
import com.vanegas1.bancotracker.databinding.CardItemBinding

class BancoRecyclerViewAdapter(private val clickListener: (BancoModel) -> Unit)
    : RecyclerView.Adapter<BancoRecyclerViewHolder>() {
    private val bancos = ArrayList<BancoModel>()

    fun setData(bancosList: List<BancoModel>){
        bancos.clear()
        bancos.addAll(bancosList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BancoRecyclerViewHolder {
        val binding = CardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BancoRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return bancos.size
    }

    override fun onBindViewHolder(holder: BancoRecyclerViewHolder, position: Int) {
        val banco = bancos[position]
        holder.bind(banco, clickListener)
    }
}