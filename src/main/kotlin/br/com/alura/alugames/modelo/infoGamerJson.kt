package br.com.alura.alugames.modelo
/*Serve como uma espécie de modelo de como é um tipo Jogo, será usada na criação de uma Extension
com nome JogoExtension.kt.
Essa extension transformará o o tipo InfoGame em tipo Jogo*/
data class InfoGamerJson(
    val nome: String,
    val email: String,
    val dataNascimento: String,
    val usuario: String)