package br.com.alura.alugames.utilitario

import br.com.alura.alugames.modelo.Jogo
import br.com.alura.alugames.modelo.infoJogoJson

fun infoJogoJson.criarJogo(): Jogo{
    return Jogo(this.titulo, this.capa, this.preco, this.descricao, this.id)
}