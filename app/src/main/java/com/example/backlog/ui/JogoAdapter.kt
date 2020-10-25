package com.example.backlog.ui

import android.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import com.example.backlog.R
import com.example.backlog.model.Jogo

class JogoAdapter(
    private val activity: FragmentActivity,
    private val viewModel: JogoViewModel,
    private val Jogos: List<Jogo>
) : RecyclerView.Adapter<JogoViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JogoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_jogo, parent, false)
        return JogoViewHolder(view)
    }

    override fun onBindViewHolder(holder: JogoViewHolder, position: Int) {
        val Jogo = Jogos[position]
        holder.idJogo.text = Jogo.id.toString()
        holder.nomeJogo.text = Jogo.nome
        holder.itemView.setOnClickListener{ view ->
                viewModel.jogo.value = Jogo
                view.findNavController().navigate(R.id.DetalharJogo)
        }

        holder.itemView.setOnLongClickListener{ view ->

            view?.let {
                AlertDialog.Builder(activity).setTitle("Atenção")
                    .setMessage("Certeza que quer excluir o jogo?")
                    .setPositiveButton("Claro"){
                        dialog, which ->
                        viewModel.removerJogo(Jogo.id)
                    }
                    .setNegativeButton("Nop", null)
                    .show()
            }
            true
        }

    }

    override fun getItemCount(): Int = Jogos.size


}
