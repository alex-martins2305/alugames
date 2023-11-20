import br.com.alura.alugames.modelo.Jogo
import br.com.alura.alugames.DADOS.jogosDAO

fun main() {
    val jogoTeste1=Jogo("Teste22","Teste22",10.1, "Teste22", 6)
    val jogoDAO= jogosDAO()
    //jogoDAO.adicionarJogo(jogoTeste1)
    val listaJogos:List<Jogo> =jogoDAO.getJogos()

    println(listaJogos)
}




