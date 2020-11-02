package com.example.backlog.db
/*
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.backlog.model.Jogo

@Dao
interface JogoDAO {

    @Query("SELECT * FROM Jogos")
    fun listarJogos() : LiveData<List<Jogo>>

    @Insert
    suspend fun cadastrarJogo(jogo : Jogo)

    @Update
    suspend fun atualizarJogo(jogo : Jogo)

    @Query("DELETE FROM Jogos WHERE id = (:id)")
    suspend fun removerJogo(id: Int)

    @Query("DELETE FROM Jogos")
    suspend fun removerTodosJogos()
}*/