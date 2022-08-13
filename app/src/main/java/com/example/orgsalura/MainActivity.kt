package com.example.orgsalura

import android.app.Activity
import android.os.Bundle
import android.widget.Toast

/**
 * Estamos herdando o "Activity" para definir que essa classe será uma "Activity".
 */
class MainActivity : Activity() {

    /**
     * Quando a activity for inicializada, o método "onCreate" será executado.
     */
    override fun onCreate(savedInstanceState: Bundle?){

        /**
         * O "super" configurará o ciclo de vida dos componentes.
         */
        super.onCreate(savedInstanceState)

        /**
         * O "Toast" é um componente que exibirá uma mensagem para o usuário.
         *
         * O primeiro argumento, o "context", representará o ponto em que estamos em um
         * aplicativo, além de permitir acesso à vários recursos do Android.
         */
        Toast.makeText(this,"Olá, mundo!", Toast.LENGTH_SHORT).show()
    }
}