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

        view.findViewById<ImageButton>(R.id.buscemi).setOnClickListener(){
            val text = "Hello toast!"
            val duration = Toast.LENGTH_SHORT

            val toast = Toast.makeText(requireActivity(), text, duration)
            toast.show()
        }

        viewModel.jogo.observe(viewLifecycleOwner, {jogo ->

            txtNome.setText(jogo.nome)
            txtYear2.setText(jogo.ano.toString())
            txtSeila.setText(jogo.plataforma)

          view.findViewById<Button>(R.id.btnSave).setOnClickListener {
                val nome = txtNome.text.toString()
                val ano = txtYear2.text.toString()
                val plataforma = txtSeila.text.toString()
                viewModel.cadastrarJogo(Jogo(id = jogo.id, nome = nome, ano = ano, plataforma = plataforma))
                findNavController().navigateUp()
          }

        })

        return view
    }
}
