package com.vanegas1.bancotracker

import android.app.Application
import com.vanegas1.bancotracker.data.bancos
import com.vanegas1.bancotracker.repositories.BancoRepository

class BancoReviewerApplication: Application() {
    val bancoRepository: BancoRepository by lazy {
        BancoRepository(bancos)
    }
}