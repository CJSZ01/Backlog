package com.example.backlog.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_jogo.view.*

class JogoViewHolder (val mView: View) : RecyclerView.ViewHolder(mView) {
    val idJogo: TextView = mView.idJogo
    val nomeJogo: TextView = mView.nomeJogo

    override fun toString(): String {
        return super.toString() + " '" + nomeJogo.text + "'"
    }
}
