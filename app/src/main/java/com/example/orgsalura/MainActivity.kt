package com.example.orgsalura

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

/**
 * Estamos herdando o "Activity" para definir que essa classe será uma "Activity".
 *
 * Na activity, não podemos manter muito código que é de responsabilidade dela. Todo o
 * código que pode ser extraído para outro lugar, deve ser feito.
 *
 * Toda a complexidade do layout deve ser enviada para um arquivo separado da Activity.
 *
 */
class MainActivity : Activity() {

    /**
     * Quando a activity for inicializada, o método "onCreate" será executado.
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

        val viewNomeProduto = findViewById<TextView>(R.id.nome) //Estamos buscando a textview através do ID.

        viewNomeProduto.text = "Salada de frutas!" //Isso é o "bind", ou seja, a vinculação do código-fonte com o arquivo de layout.

        val viewDescricaoProduto = findViewById<TextView>(R.id.descricao)

        viewDescricaoProduto.text = "Laranja, manga e maçã!"

        val viewValorProduto = findViewById<TextView>(R.id.descricao)

        viewValorProduto.text = "19.99"

//        /**
//         * O "Toast" é um componente que exibirá uma mensagem para o usuário.
//         *
//         * O primeiro argumento, o "context", representará o ponto em que estamos em um
//         * aplicativo, além de permitir acesso à vários recursos do Android.
//         */
//        Toast.makeText(this,"Olá, mundo!", Toast.LENGTH_SHORT).show()
    }
}