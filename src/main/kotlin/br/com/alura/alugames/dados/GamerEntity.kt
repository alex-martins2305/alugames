package br.com.alura.alugames.dados

import javax.persistence.*

@Entity
@Table(name = "gamers")
class GamerEntity(
    var nome:String="Nome do gamer",
    val email:String="Email do gamer",
    val dataNascimento:String="Data Nasc Gamer",
    val usuario:String="Usuario do Gamer",
    @Id //@GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Int=0) {
}
