package br.com.alura.alugames.modelo

import com.google.gson.annotations.Expose
import javax.persistence.*

@Entity
@Table(name = "jogos")
data class Jogo(@Expose var titulo:String, @Expose val capa:String): Recomendavel {
    var descricao: String? = null
    var preco = 0.0
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = 0
    @Transient
    private val listaNotas = mutableListOf<Int>()
    override val media: Double
        get() = listaNotas.average()
    constructor():this("","") //constructor é obrigatório da class Entity.
    constructor(titulo: String, capa: String, preco: Double, descricao: String, id:Int = 0) :
            this(titulo,capa) {
                this.preco=preco
                this.descricao=descricao
                this.id=id
    }

    override fun recomendar(nota: Int) {
        listaNotas.add(nota)
    }

    override fun toString(): String {
        return "Meu Jogo: \n" +
                "Título: $titulo \n" +
                "Capa: $capa \n" +
                "Descricao: $descricao \n" +
                "Preço: $preco \n" +
                "Reputação: $media\n" +
                "Id: $id"
    }
}