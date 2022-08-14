package com.example.orgsalura.ui.dao

import com.example.orgsalura.ui.model.Produto

class ProdutosDao {

    fun adiciona(produto: Produto){

        produtos.add(produto)
    }

    fun buscaTodos(): List<Produto> {
        return produtos.toList()
    }

    companion object { //É como se fosse um "static" do Java, ou seja, esses valores ficarão disponíveis independentemente da instância.

        private val produtos = mutableListOf<Produto>() //Essa lista conterá os produtos adicionados. Ele será um "banco de dados" em memória.
    }
}