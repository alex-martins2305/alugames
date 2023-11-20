package br.com.alura.alugames.modelo

import br.com.alura.alugames.modelo.Gamer

class planoAssinatura(
    tipo:String,
    val mensalidade: Double,
    val jogoIncluidos: Int,
    val percentualDescontoReputacao: Double,
    id:Int=0):Plano(tipo, id) {

    override fun obterValor(aluguel: Aluguel): Double {
        val totalJogosNoMes=aluguel.Gamer.jogosDoMes(aluguel.periodo.dataInicial.monthValue).size+1
        return if (totalJogosNoMes<=jogoIncluidos) {
            0.0
        } else {
            var valorOriginal=super.obterValor(aluguel)
            if (aluguel.Gamer.media>8) {
                valorOriginal-=valorOriginal*percentualDescontoReputacao
            }
            return valorOriginal
        }
    }

}