package com.example.backlog.ui

import android.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.example.backlog.R
import com.example.backlog.model.Jogo
import com.google.firebase.storage.FirebaseStorage

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
        holder.nomeJogo.text = Jogo.nome
        holder.anoJogo.text = Jogo.ano

        val storage = FirebaseStorage.getInstance()
        val storageReference = storage.getReference(Jogo.foto)
        storageReference.downloadUrl.addOnSuccessListener { imageUrl ->
            Glide.with(activity)
                .load(imageUrl)
                .into(holder.fotoJogo)
        }

        storageReference.downloadUrl.addOnFailureListener {
            Glide.with(activity)
                .load(R.drawable.recruta)
                .into(holder.fotoJogo)
        }

        holder.itemView.setOnClickListener { view ->
            viewModel.jogo.value = Jogo
            view.findNavController().navigate(R.id.DetalharJogo)
        }

        holder.itemView.setOnLongClickListener { view ->
            view?.let {
                AlertDialog.Builder(activity).setTitle("Atenção")
                    .setMessage("Certeza que quer excluir o jogo?")
                    .setPositiveButton("Claro") { dialog, which ->
                        viewModel.repository.removerJogo(Jogo.docId)
                    }
                    .setNegativeButton("Nop", null)
                    .show()
            }
            true
        }
    }

    override fun getItemCount(): Int = Jogos.size

}
