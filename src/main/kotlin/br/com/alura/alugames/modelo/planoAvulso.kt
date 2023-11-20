package br.com.alura.alugames.modelo
 import br.com.alura.alugames.modelo.Aluguel

class planoAvulso(tipo:String, id:Int):Plano(tipo, id) {

    override fun obterValor(aluguel: Aluguel): Double {
        var valorOriginal=super.obterValor(aluguel)
            if (aluguel.Gamer.media>8) {
                valorOriginal-=valorOriginal*0.1
                return valorOriginal
            } else {
                return valorOriginal
            }
        }

    }

