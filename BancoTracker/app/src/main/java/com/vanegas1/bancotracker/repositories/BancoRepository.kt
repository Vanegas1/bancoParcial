package com.vanegas1.bancotracker.repositories

import com.vanegas1.bancotracker.data.model.BancoModel

class BancoRepository(private val bancos: MutableList<BancoModel>) {
    fun getBancos() = bancos
    fun addBancos(newBanco: BancoModel) = bancos.add(newBanco)
}