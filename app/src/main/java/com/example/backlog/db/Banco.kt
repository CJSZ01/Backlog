package com.example.backlog.db
/*
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.backlog.model.Jogo

@Database(entities = [Jogo::class], version = 1, exportSchema = false)
abstract class Banco : RoomDatabase() {

    abstract fun JogoDAO() : JogoDAO

    companion object{
        @Volatile
        private var INSTANCE : Banco? = null
        fun get(context : Context) : Banco{
            var instance = INSTANCE
            if (instance == null){
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    Banco::class.java,
                    "Banco.db"
                ).build()
            }
            return instance!!
        }
    }
}*/