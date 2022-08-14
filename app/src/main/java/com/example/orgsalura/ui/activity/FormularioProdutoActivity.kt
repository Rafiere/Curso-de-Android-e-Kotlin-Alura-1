package com.example.orgsalura.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.orgsalura.R
import com.example.orgsalura.ui.dao.ProdutosDao
import com.example.orgsalura.ui.model.Produto
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.math.BigDecimal

/**
 * O "AppCompatActivity()" é uma especialização padrão da
 * classe "Activity". Ela traz uma AppBar, que é um componente
 * visual junto com ela. Essa AppCompat herda da classe base do
 * "Activity", porém, ele mantém a compatibilidade com versões antigas
 * do Android.
 *
 * O "AppCompatActivity" vem do "AndroidX". O "AndroidX" faz parte do
 * conjunto de bibliotecas do "Android Jetpack", que é um conjunto de
 * bibliotecas bem vistas pela ocmunidade.
 */
class FormularioProdutoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_produto)

        val botaoSalvar = findViewById<Button>(R.id.botao_salvar)

        botaoSalvar.setOnClickListener { //Quando o botão "botao_salvar" for pressionado, os dados do campo serão enviados para essa variável.

            val campoNome = findViewById<EditText>(R.id.nome)
            val nome = campoNome.text.toString() //Estamos obtendo o texto que foi inserido no campo "nome".

            val campoDescricao = findViewById<EditText>(R.id.descricao)
            val descricao = campoDescricao.text.toString()

            val campoPreco = findViewById<EditText>(R.id.valor)
            val precoEmTexto = campoPreco.text.toString()

            val valor = if(precoEmTexto.isBlank()){ //Estamos utilizando uma "if expression"
                BigDecimal.ZERO
            }else{
                BigDecimal(precoEmTexto)
            }

            val produtoNovo = Produto(
                nome = nome,
                descricao = descricao,
                valor = valor
            )

            val dao = ProdutosDao()
            dao.adiciona(produtoNovo)
        }
    }
}