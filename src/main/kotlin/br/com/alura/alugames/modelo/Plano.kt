package br.com.alura.alugames.modelo

abstract class Plano(val tipo:String, var id:Int=0) {
    open fun obterValor(aluguel:Aluguel):Double{
        return aluguel.periodo.emDias.toDouble()* aluguel.Jogo.preco!!
    }
}