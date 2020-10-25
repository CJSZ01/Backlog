package com.example.backlog.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.example.backlog.R
import com.example.backlog.model.Jogo
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.lista_de_jogos.*

class ListaDeJogoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.lista_de_jogos, container, false)
        var recycler = view.findViewById<RecyclerView>(R.id.list)
        var viewModel = ViewModelProvider(requireActivity()).get(JogoViewModel::class.java)
        viewModel.listaDeJogos.observe(requireActivity(), {jogos ->
            with(recycler){
                adapter = JogoAdapter(requireActivity(), viewModel, jogos)
            }
        })

        view.findViewById<FloatingActionButton>(R.id.FAB).setOnClickListener{
            viewModel.jogo.value = Jogo()
            findNavController().navigate(R.id.DetalharJogo)
        }

        return view
    }

}
