package br.com.alura.alugames.modelo

import java.time.LocalDate
import java.util.Scanner
import kotlin.random.Random

data class Gamer(var nome:String, var email:String):Recomendavel {
    var dataNascimento:String? = null
    var usuario:String? = null
        set(value) {
            field = value
            if(idInterno.isNullOrBlank()) {
                criarIdInterno()
            }
        }
    var id=0
    var idInterno:String? = null
        private set
    var plano:Plano=planoAvulso("BRONZE",0)
    val jogosBuscados = mutableListOf<Jogo?>()
    val jogosAlugados= mutableListOf<Aluguel>()
    private val listaNotas= mutableListOf<Int>()
    val jogosRecomendados= mutableListOf<Jogo>()

    override val media: Double
        get() = listaNotas.average()

    override fun recomendar(nota: Int) {
        if (nota>=0 && nota<=10) {
            listaNotas.add(nota)
        } else {
            println("ATENÇÃO: A nota deve ser entre 0 e 10!")
        }
    }

    fun recomendarJogo (Jogo: Jogo, nota:Int){
        Jogo.recomendar(nota)
        jogosRecomendados.add(Jogo)
    }

    constructor(nome: String, email: String, dataNascimento:String, usuario:String, id:Int=0):
            this(nome, email) {
        this.dataNascimento = dataNascimento
        this.usuario = usuario
        this.id = id
        criarIdInterno()
    }

    init {
        if (nome.isNullOrBlank()) {
            throw IllegalArgumentException("Nome está em branco")
        }
        this.email = validarEmail()
    }

    override fun toString(): String {
        return "Gamer:\n"+
                "nome=$nome\n"+
                "email=$email\n"+
                "dataNascimento=$dataNascimento\n"+
                "usuario=$usuario\n"+
                "idInterno=$idInterno)\n"+
                "Reputação=${String.format("%.2f",media)}"+
                "Id: $id"
    }

    fun criarIdInterno() {
        val numero = Random.nextInt(10000)
        val tag = String.format("%04d", numero)

        idInterno = "$usuario#$tag"
    }

    fun validarEmail(): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (regex.matches(email)) {
            return email
        } else {
            throw IllegalArgumentException("Email inválido")
        }

    }

    fun alugaJogo(Jogo:Jogo, periodo:Periodo):Aluguel{
        val aluguel=Aluguel(this, Jogo, periodo)
        jogosAlugados.add(aluguel)
        return aluguel
    }
    fun jogosDoMes(mes:Int): List<Jogo> {
        return jogosAlugados
            .filter { aluguel ->  aluguel.periodo.dataInicial.monthValue == mes}
            .map { aluguel ->  aluguel.Jogo}
    }

    companion object {
        fun criarGamer(leitura: Scanner): Gamer {
            println("Boas vindas ao AluGames! Vamos fazer seu cadastro. Digite seu nome:")
            val nome = leitura.nextLine()
            println("Digite seu e-mail:")
            val email = leitura.nextLine()
            println("Deseja completar seu cadastro com usuário e data de nascimento? (S/N)")
            val opcao = leitura.nextLine()

            if (opcao.equals("s", true)) {
                println("Digite sua data de nascimento(DD/MM/AAAA):")
                val nascimento = leitura.nextLine()
                println("Digite seu nome de usuário:")
                val usuario = leitura.nextLine()

                return Gamer(nome, email, nascimento, usuario)
            } else {
                return Gamer (nome, email)
            }

        }
    }

}