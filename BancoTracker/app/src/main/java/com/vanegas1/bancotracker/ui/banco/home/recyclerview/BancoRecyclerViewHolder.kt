package com.vanegas1.bancotracker.ui.banco.home.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.vanegas1.bancotracker.data.model.BancoModel
import com.vanegas1.bancotracker.databinding.CardItemBinding

class BancoRecyclerViewHolder (private val binding: CardItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(banco: BancoModel, clickListener: (BancoModel) -> Unit){
        binding.bankTextView.text = banco.name
        binding.countryTextView.text = banco.country

        binding.bank1Card.setOnClickListener{
            clickListener(banco)
        }
    }
}