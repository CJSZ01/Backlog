package com.example.backlog.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Jogos")
data class Jogo(

    @PrimaryKey(autoGenerate = true)
    var id : Int,
    var nome : String,
    var ano : String,
    var plataforma : String

)
{
    constructor() : this(0, String(), String (), String())
}



