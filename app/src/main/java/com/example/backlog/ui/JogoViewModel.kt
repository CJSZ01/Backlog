package com.example.backlog.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.backlog.model.Jogo
import com.example.backlog.repository.JogoRepository
import kotlinx.coroutines.launch

class JogoViewModel(app: Application) : AndroidViewModel(app) {
    var jogo = MutableLiveData<Jogo>()
    var repository = JogoRepository()
    var listaDeJogos = repository.listaDeJogos

}
