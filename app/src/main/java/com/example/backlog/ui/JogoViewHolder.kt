package com.example.backlog.ui

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.backlog.R
import kotlinx.android.synthetic.main.item_jogo.view.*
import kotlinx.android.synthetic.main.jogo_fragment.view.*

class JogoViewHolder (val view: View) : RecyclerView.ViewHolder(view) {

    val nomeJogo: TextView = view.findViewById(R.id.textoNome)
    val anoJogo: TextView = view.findViewById(R.id.textoAno)
    val fotoJogo: ImageView = view.findViewById(R.id.imgFoto)

    override fun toString(): String {
        return super.toString() + " '" + nomeJogo.text + "'"
    }
}
