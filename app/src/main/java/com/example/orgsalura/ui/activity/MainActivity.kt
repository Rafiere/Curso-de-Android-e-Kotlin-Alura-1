package com.example.orgsalura.ui.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.orgsalura.R
import com.example.orgsalura.ui.dao.ProdutosDao
import com.example.orgsalura.ui.model.Produto
import com.example.orgsalura.ui.recyclerview.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.math.BigDecimal

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
class MainActivity : AppCompatActivity() {

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
         * Todo componente deve ter uma view.
         */
        super.onCreate(savedInstanceState)

        val view = TextView(this)

        /**
         * A classe "R" fornece acesso aos resources que estão dentro do pacote "res", como os layouts das
         * activities.
         */

        setContentView(R.layout.activity_main) //Definiremos a view que aparecerá nesse content quando ele for criado.

//        /**
//         * Buscando as views e preenchendo os seus valores.
//         */
//
//        val viewNomeProduto = findViewById<TextView>(R.id.nome) //Estamos buscando a textview através do ID.
//
//        viewNomeProduto.text = "Salada de frutas!" //Isso é o "bind", ou seja, a vinculação do código-fonte com o arquivo de layout.
//
//        val viewDescricaoProduto = findViewById<TextView>(R.id.descricao)
//
//        viewDescricaoProduto.text = "Laranja, manga e maçã!"
//
//        val viewValorProduto = findViewById<TextView>(R.id.descricao)
//
//        viewValorProduto.text = "19.99"

//        /**
//         * O "Toast" é um componente que exibirá uma mensagem para o usuário.
//         *
//         * O primeiro argumento, o "context", representará o ponto em que estamos em um
//         * aplicativo, além de permitir acesso à vários recursos do Android.
//         */
//        Toast.makeText(this,"Olá, mundo!", Toast.LENGTH_SHORT).show()
    }

    override fun onResume(){
        super.onResume()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val dao = ProdutosDao()

        recyclerView.adapter = ListaProdutosAdapter(context = this,
            produtos = dao.buscaTodos())

//        recyclerView.adapter = ListaProdutosAdapter(this, listOf(
//            Produto(nome = "Teste", "Descrição", valor = BigDecimal.ONE),
//            Produto(nome = "Teste", "Descrição", valor = BigDecimal.TEN))
//        )

        recyclerView.layoutManager = LinearLayoutManager(this)

        configurarFab()
    }

    private fun configurarFab() {
        val floatingActionButton = findViewById<FloatingActionButton>(R.id.addAProduct)

        floatingActionButton.setOnClickListener {

            val intent = Intent(this, FormularioProdutoActivity::class.java)
            startActivity(intent) //Quando o botão "+" for clicado, a Activity "FormulatioProdutoActivity" será
            //chamada. Cada vez que uma activity é criada, ela é inserida sob a acitivity
            //atual, formando uma pilha de execuções.
        }
    }
}