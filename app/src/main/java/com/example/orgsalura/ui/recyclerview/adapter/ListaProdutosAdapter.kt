package com.example.orgsalura.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.orgsalura.R
import com.example.orgsalura.ui.model.Produto

/**
 * O adapter é o componente responsável para indicar para o RecyclerView quais
 * views serão criadas, a quantidade de views e como funcionará o processo de binding. A
 * configuração do gerenciador de layout deverá ser responsabilidade do Recycler View.
 */

class ListaProdutosAdapter(
    private val context: Context,
    private val produtos: List<Produto>
) : RecyclerView.Adapter<ListaProdutosAdapter.ListaProdutosViewHolder>() {

    class ListaProdutosViewHolder(view: View): RecyclerView.ViewHolder(view) {

        fun vincula(produto: Produto) {

            val nome = itemView.findViewById<TextView>(R.id.nome)
            nome.text = produto.nome

            val descricao = itemView.findViewById<TextView>(R.id.descricao)
            descricao.text = produto.descricao

            val valor = itemView.findViewById<TextView>(R.id.valor)
            valor.text = produto.valor.toPlainString()
        }
    }

    //O "view holder" será o responsável por pegar a Recycle View e permitir que as modificações
    //nesse componente sejam realizadas.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaProdutosAdapter.ListaProdutosViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.produto_item, parent, false)
        return ListaProdutosViewHolder(view)
    }

    //Esse método preencherá os campos de cada uma das views que foram pegas pelo view holder, que
    //é o método acima. Para o preenchimento desses campos, utilizaremos o método "vincula()".
    override fun onBindViewHolder(holder: ListaProdutosViewHolder, position: Int) {
        val produto = produtos[position]
        holder.vincula(produto)
    }

    //Esse método obterá a quantidade de itens que estão dentro da coleção que foi obtida no RecyclerView.
    override fun getItemCount(): Int {

        return produtos.size
    }

}
