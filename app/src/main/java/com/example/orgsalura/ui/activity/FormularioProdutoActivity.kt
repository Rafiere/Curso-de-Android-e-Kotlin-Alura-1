package com.example.orgsalura.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.orgsalura.R
import com.example.orgsalura.ui.dao.ProdutosDao
import com.example.orgsalura.ui.model.Produto
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
class FormularioProdutoActivity : AppCompatActivity(R.layout.activity_formulario_produto) { //Estamos definindo o layout que será carregado.

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        configurarBotaoSalvar()
    }

    private fun configurarBotaoSalvar() {

        val botaoSalvar = findViewById<Button>(R.id.activity_formulario_produto_botao_salvar)

        val dao = ProdutosDao()

        botaoSalvar.setOnClickListener { //Quando o botão "botao_salvar" for pressionado, os dados do campo serão enviados para essa variável.
            val produtoNovo = criaProduto()
            dao.adiciona(produtoNovo)
            finish() //Fecharemos essa Activity e retornaremos para a activity anterior da pilha de activities.
        }
    }

    private fun criaProduto(): Produto {

        val campoNome = findViewById<EditText>(R.id.activity_formulario_produto_nome)
        val nome = campoNome.text.toString() //Estamos obtendo o texto que foi inserido no campo "nome".

        val campoDescricao = findViewById<EditText>(R.id.activity_formulario_produto_descricao)
        val descricao = campoDescricao.text.toString()

        val campoPreco = findViewById<EditText>(R.id.activity_formulario_produto_valor)
        val precoEmTexto = campoPreco.text.toString()

        val valor = if (precoEmTexto.isBlank()) { //Estamos utilizando uma "if expression" para atribuir o valor dos códigos no bloco do "if" diretamente à variável "valor".
            BigDecimal.ZERO
        } else {
            BigDecimal(precoEmTexto)
        }

        return Produto( //Retornando o produto que foi criado com base nos dados do formulário.
            nome = nome,
            descricao = descricao,
            valor = valor
        )
    }
}