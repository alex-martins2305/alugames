import br.com.alura.alugames.dados.Banco
import br.com.alura.alugames.dados.GamerDAO
import br.com.alura.alugames.modelo.Gamer


fun main() {
    val gamer1= Gamer("alex", "alex@email.com", "23/05/1979", "alexpb3", 10)
    val gamer2= Gamer("lano", "lano@email.com", "28/01/1983", "lano", 20)
    val gamer3= Gamer("gaso", "gaso@email.com", "12/09/1980", "gaso", 30)

    val manager = Banco.getEntityManager()
    val gamerDAO= GamerDAO(manager)

    gamerDAO.adicionarGamer(gamer1)
    gamerDAO.adicionarGamer(gamer2)
    gamerDAO.adicionarGamer(gamer3)
    gamerDAO.updateGamer(gamer2)
    gamerDAO.deletaGamer(gamer3)


    val listaGamers:List<Gamer> =gamerDAO.getGamers()
    manager.close()

    println(listaGamers)
}