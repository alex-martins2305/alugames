package br.com.alura.alugames.principal
import br.com.alura.alugames.modelo.Gamer
import br.com.alura.alugames.modelo.Periodo
import br.com.alura.alugames.modelo.planoAssinatura
import br.com.alura.alugames.servicos.ConsumoApi
import com.google.gson.GsonBuilder
import transformarEmData
import java.io.File
import java.lang.Exception
import java.time.LocalDate
import java.util.Scanner

fun main () {
    val consumo= ConsumoApi()
    val listaGamers=consumo.buscaGamers()
    //val jogoBuscado=consumo.buscaJogo("151")
    val listaJogoJson=consumo.buscaJogoS()
    //val jogo1= Jogo(jogoBuscado.info.title, jogoBuscado.info.thumb)

//    println(listaGamers)
//    println(gameApi)
    println("Digite o código do jogo para alugar:")
    var scn=Scanner(System.`in`)
    var codigoJogo=scn.nextInt()
    println("Digite o código do Jogador que alugará o jogo:")
    var codigoGamer=scn.nextInt()
    println("Código do jogo é $codigoJogo.")
    println("Codigo do Gamer é $codigoGamer.")

    //val run =runCatching {
        val gamer1=listaGamers.get(codigoGamer)
        val jogo1=listaJogoJson.get(codigoJogo)
        val jogo2=listaJogoJson.get(0)
        val jogo3=listaJogoJson.get(1)
        val periodo1=Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
        val periodo2=Periodo(LocalDate.now(), LocalDate.now().plusDays(3))
        val aluguel=gamer1.alugaJogo(jogo1,periodo1)
        val aluguel2=gamer1.alugaJogo(jogo2, periodo1)
        val aluguel3=gamer1.alugaJogo(jogo3, periodo1)
        //val aluguel=gamer1.alugaJogo(jogo1,"10/10/2000".transformarEmData(),"15/10/2000".transformarEmData())
        println(aluguel)
        println("Lista de filmes alugador pelo Gamer1:\n ${gamer1.jogosAlugados}")
//    }
//    run.onFailure {
//        println()
//        println("Usuário ou Jogo não econtrado!")
//
//    }
    val gamerCamila= listaGamers.get(4)
    gamerCamila.plano=planoAssinatura("PRATA", 9.90, 1, 0.50 )
    val gamerCaroline = listaGamers.get(3)
    val jogoResidentVillage = listaJogoJson.get(10)
    val jogoSpider = listaJogoJson.get(13)
    val jogoTheLastOfUs = listaJogoJson.get(2)
    val jogoDandara = listaJogoJson.get(5)
    val jogoAssassins = listaJogoJson.get(4)
    val jogoCyber = listaJogoJson.get(6)
    val jogoGod = listaJogoJson.get(7)
    val jogoSkyrim = listaJogoJson.get(18)

    gamerCamila.recomendarJogo(jogoResidentVillage, 7)
    gamerCamila.recomendarJogo(jogoTheLastOfUs, 10)
    gamerCamila.recomendarJogo(jogoAssassins, 8)
    gamerCamila.recomendarJogo(jogoCyber, 7)
    gamerCamila.recomendarJogo(jogoGod, 10)
    gamerCamila.recomendarJogo(jogoDandara, 8)
    gamerCamila.recomendarJogo(jogoSkyrim, 8)
    gamerCamila.recomendarJogo(jogoSpider, 6)

    var gson=GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    var serializacao=gson.toJson(gamerCamila.jogosRecomendados)
    println(serializacao)
    var arquivo= File("${gamerCamila.nome}.json")
    arquivo.writeText(serializacao)
    println(arquivo)
}