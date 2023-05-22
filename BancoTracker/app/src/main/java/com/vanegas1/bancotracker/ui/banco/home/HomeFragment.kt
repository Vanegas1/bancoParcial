package com.vanegas1.bancotracker.ui.banco.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.vanegas1.bancotracker.R
import com.vanegas1.bancotracker.data.model.BancoModel
import com.vanegas1.bancotracker.databinding.FragmentHomeBinding
import com.vanegas1.bancotracker.ui.banco.home.recyclerview.BancoRecyclerViewAdapter
import com.vanegas1.bancotracker.ui.banco.viewmodel.BancoViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class HomeFragment : Fragment() {
    private val bancoViewModel:BancoViewModel by activityViewModels {
        BancoViewModel.Factory
    }

    private lateinit var adapter: BancoViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView(view)

        binding.actionToNewBank.setOnClickListener{
            bancoViewModel.clearData()
            it.findNavController().navigate(R.id.action_homeFragment_to_newBancoFragment)
        }
    }

    private fun setRecyclerView(view:View){
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = BancoRecyclerViewAdapter { selectedBanco ->
            showSelectedItem(selectedBanco)
        }

        binding.recyclerView.adapter = adapter
        displayBanco()
    }

    private fun showSelectedItem(banco: BancoModel){
        bancoViewModel.setSelectedBanco(banco)
        findNavController().navigate(R.id.action_homeFragment_to_bancoFragment)
    }

    private fun displayMovie(){
        adapter.setData(moieViewModel.getMovies())
        adapter.notifyDataSetChanged()
    }
}