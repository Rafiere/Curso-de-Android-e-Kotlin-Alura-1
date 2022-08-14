package com.example.orgsalura.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.orgsalura.R
import com.example.orgsalura.ui.dao.ProdutosDao
import com.example.orgsalura.ui.recyclerview.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * Estamos herdando o "Activity" para definir que essa classe será uma "Activity".
 *
 * Na activity, não podemos manter muito código que é de responsabilidade dela. Todo o
 * código que pode ser extraído para outro lugar, deve ser feito.
 *
 * Toda a complexidade do layout deve ser enviada para um arquivo separado da Activity.
 *
 * Update: Passamos a herdar a "AppCompatActivity", que é uma classe do AndroidX que oferece uma
 * maior compatibilidade.
 */

/**
 * A classe "R" fornece acesso aos resources que estão dentro do pacote "res", como os layouts das
 * activities.
 */
class ListaProdutosActivity : AppCompatActivity(R.layout.activity_lista_produtos) { //Definiremos a view que aparecerá nesse content quando ele for criado.

    private val dao = ProdutosDao()
    private val adapter = ListaProdutosAdapter(context = this,
                                               produtos = dao.buscaTodos())


    /**
     * Quando a activity for inicializada, o método "onCreate" será executado.
     *
     * Esse código será executado apenas uma vez, pois esse método, que faz parte
     * do ciclo de vida de uma activity, será executado apenas uma vez.
     */
    override fun onCreate(savedInstanceState: Bundle?){

        /**
         * O "super" configurará o ciclo de vida dos componentes.
         *
         * Todos os componentes devem ter uma view.
         */
        super.onCreate(savedInstanceState)

        configurarRecyclerView()
        configurarFab()
    }

    override fun onResume(){

        super.onResume()
        Log.i("teste", dao.toString())
        adapter.atualiza(dao.buscaTodos())
    }

    private fun configurarFab() {
        val floatingActionButton = findViewById<FloatingActionButton>(R.id.activity_lista_produtos_fab)

        floatingActionButton.setOnClickListener {

            vaiParaFormularioProduto()
        }
    }

    private fun vaiParaFormularioProduto(){

        val intent = Intent(this, FormularioProdutoActivity::class.java)
        startActivity(intent) //Quando o botão "+" for clicado, a Activity "FormulatioProdutoActivity" será
        //chamada. Cada vez que uma activity é criada, ela é inserida sob a acitivity
        //atual, formando uma pilha de execuções.
    }

    private fun configurarRecyclerView() {

        val recyclerView = findViewById<RecyclerView>(R.id.activity_lista_produtos_recyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}