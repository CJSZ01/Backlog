package com.example.backlog.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController

import com.example.backlog.R
import com.example.backlog.model.Jogo
import kotlinx.android.synthetic.main.item_jogo.*
import kotlinx.android.synthetic.main.jogo_fragment.*

class JogoFragment : Fragment() {

    companion object {
        fun newInstance() = JogoFragment()
    }

    private lateinit var viewModel: JogoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        var view = inflater.inflate(R.layout.jogo_fragment, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(JogoViewModel::class.java)

        viewModel.jogo.observe(viewLifecycleOwner, { jogo ->

            txtNome.setText(jogo.nome)
            txtAno.setText(jogo.ano.toString())
            txtPlataforma.setText(jogo.plataforma)
            txtFoto.setText(jogo.foto)

            view.findViewById<Button>(R.id.btnSalvar).setOnClickListener {
                var jogo = Jogo(
                    docId = jogo.docId,
                    nome = txtNome.text.toString(),
                    ano = txtAno.text.toString(),
                    plataforma = txtPlataforma.text.toString(),
                    foto = txtFoto.text.toString()
                )

                viewModel.repository.cadastrarJogo(jogo)

                findNavController().navigateUp()
            }

        })

        return view
    }
}
