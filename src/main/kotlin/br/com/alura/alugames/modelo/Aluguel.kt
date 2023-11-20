package br.com.alura.alugames.modelo

import transformarEmMoney
import java.time.LocalDate
import java.time.Period
import kotlin.math.round
import kotlin.time.times

data class Aluguel(
    val Gamer:Gamer,
    val Jogo:Jogo,
    val periodo:Periodo){
    val valorDoAluguel=Gamer.plano.obterValor(this)
    var id=0
    override fun toString(): String {
        return "Aluguel do Jogo ${Jogo.titulo.uppercase()}  por ${Gamer.nome.uppercase()}, user: ${Gamer.usuario}\nAluguel: R$ ${valorDoAluguel.transformarEmMoney()}, Id: $id."
    }
}
