package br.com.alura.alugames.modelo

class carro (val nome:String, val idCarro:Int) {
    val color = "vermelho"
    fun fazTeste() {
        println("Esse teste tem nome $nome e seu Id é $idCarro.")
    }

    companion object {
        fun testeCompanion() {
            println("Testando e tentando entender como funciona o companion object")
        }
    }
    override fun toString(): String {
        return "Meu carro\n(nome='$nome'\n, idCarro=$idCarro\n, color='$color\n')"
    }

}