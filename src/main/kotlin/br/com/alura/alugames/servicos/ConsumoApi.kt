package br.com.alura.alugames.servicos

import br.com.alura.alugames.modelo.*
import br.com.alura.alugames.utilitario.criarGamer
import br.com.alura.alugames.utilitario.criarJogo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumoApi {

    private fun consomeDados (endereco:String):String {

        val client= HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()
        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

       return response.body()

    }

    fun buscaJogo(id:String): InfoJogo{
        var endereco="https://www.cheapshark.com/api/1.0/games?id=$id"
        var json =consomeDados(endereco)

        val gson = Gson()
        val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)

        return meuInfoJogo
    }

    fun buscaJogoS(): List<Jogo>{
        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"
        var json =consomeDados(endereco)
        val gson = Gson()
        val meuJogoTipo=object: TypeToken<List<infoJogoJson>>(){}.type
        val listaJogo:List<infoJogoJson> = gson.fromJson(json, meuJogoTipo)

        val listaJogoConvertida= listaJogo.map{infoGamerJson -> infoGamerJson.criarJogo() }

        return listaJogoConvertida
    }

    fun buscaGamers(): List<Gamer>{
        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"
        var json =consomeDados(endereco)
        val gson = Gson()
        val meuGamerTipo=object: TypeToken<List<InfoGamerJson>>(){}.type
        val listaGamer:List<InfoGamerJson> = gson.fromJson(json, meuGamerTipo)

        val listaGamerConvertida= listaGamer.map{infoGamerJson -> infoGamerJson.criarGamer() }

        return listaGamerConvertida
    }


}