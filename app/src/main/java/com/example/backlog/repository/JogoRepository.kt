package com.example.backlog.repository

import androidx.lifecycle.MutableLiveData
import com.example.backlog.model.Jogo
import com.google.firebase.firestore.FirebaseFirestore

class JogoRepository {

    var listaDeJogos = MutableLiveData<MutableList<Jogo>>()
    private val db = FirebaseFirestore.getInstance()

    init {
        db.collection("Jogos")
            .get()
            .addOnCompleteListener{docs ->
                if (docs.isSuccessful){
                    var jogos = mutableListOf<Jogo>()
                    docs.result?.forEach{ doc ->
                        val jogo = doc.toObject(Jogo::class.java)
                        if (jogo != null){
                            jogo.docId = doc.id
                            jogos.add(jogo)
                        }
                    }
                    listaDeJogos.value = jogos
                } else{
                    listaDeJogos.value = mutableListOf()
                }
            }
        db.collection("jogos")
            .addSnapshotListener{ snapshot, _ ->
                if(snapshot != null){
                    var jogos = mutableListOf<Jogo>()
                    snapshot.documents?.forEach{ doc ->
                        val jogo = doc.toObject(Jogo::class.java)
                        if (jogo != null){
                            jogo.docId = doc.id
                            jogos.add(jogo)
                        }
                    }
                    listaDeJogos.value = jogos
                }

            }
    }

    fun cadastrarJogo(jogo: Jogo){
        if(jogo.docId.isBlank()){
            var doc = db.collection("jogos").document()
            jogo.docId = doc.id
            doc.set(jogo)
        } else{
            db.collection("jogos")
                .document(jogo.docId)
                .set(jogo)
        }
    }

    fun removerJogo(docId : String){
        db.collection("jogos")
            .document(docId)
            .delete()
    }

}