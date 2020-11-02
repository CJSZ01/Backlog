package com.example.backlog.model

import androidx.room.Entity
import androidx.room.PrimaryKey



data class Jogo(

    var docId : String,
    var nome : String,
    var ano : String,
    var plataforma : String,
    var foto : String

)
{
    constructor() : this(String(), String(), String (), String(), String())
}



