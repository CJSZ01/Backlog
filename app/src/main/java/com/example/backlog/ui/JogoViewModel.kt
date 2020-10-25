package com.example.backlog.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.backlog.db.Banco
import com.example.backlog.db.JogoDAO
import com.example.backlog.model.Jogo
import kotlinx.coroutines.launch

class JogoViewModel(app: Application) : AndroidViewModel(app) {
    var jogo = MutableLiveData<Jogo>()
    val JogoDAO = Banco.get(app).JogoDAO()
    var listaDeJogos = JogoDAO.listarJogos()

    fun cadastrarJogo(jogo: Jogo) = viewModelScope.launch {
        if(jogo.id == 0){
            JogoDAO.cadastrarJogo(jogo)
        } else {
            JogoDAO.atualizarJogo(jogo)
        }
    }

    fun removerJogo(id : Int) = viewModelScope.launch{
        JogoDAO.removerJogo(id)
    }

}
