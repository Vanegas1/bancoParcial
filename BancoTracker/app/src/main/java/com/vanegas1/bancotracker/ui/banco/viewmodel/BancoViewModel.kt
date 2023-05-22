package com.vanegas1.bancotracker.ui.banco.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.vanegas1.bancotracker.BancoReviewerApplication
import com.vanegas1.bancotracker.data.model.BancoModel
import com.vanegas1.bancotracker.repositories.BancoRepository

class BancoViewModel(private val repository: BancoRepository):ViewModel() {
    var name = MutableLiveData("")
    var country = MutableLiveData("")
    var status = MutableLiveData("")

    fun geBancos() = repository.getBancos()
    fun addBancos(banco: BancoModel) = repository.addBancos(banco)

    private fun validateData(): Boolean{
        when{
            name.value.isNullOrEmpty() -> return false
            country.value.isNullOrEmpty() -> return false

        }
        return true
    }

    fun createBanco(){
        if (!validateData()){
            status.value = WRONG_DATA
            return
        }

        val newBanco = BancoModel(
            name.value.toString(),
            country.value.toString(),
        )

        addBancos(newBanco)
        status.value = MOVIE_CREATED
    }

    fun clearStatus(){
        status.value = INACTIVE
    }

    fun clearData(){
        name.value = ""
        country.value = ""
    }

    fun setSelectedBanco(movie: BancoModel){
        name.value = movie.name
        country.value = movie.country
    }

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as BancoReviewerApplication
                BancoViewModel(app.bancoRepository)
            }
        }

        const val MOVIE_CREATED = "Banco created"
        const val WRONG_DATA = "Wrong data"
        const val INACTIVE = ""
    }
}