import java.time.LocalDate
import java.time.LocalDate.*
import java.time.Period.*
import java.time.format.DateTimeFormatter.*

fun String.tranformarEmIdade(): Int {
    val formatter = ofPattern("dd/MM/yyyy")
    var idade = 0
    val dataNascimento = parse(this, formatter)
    val hoje = now()
    idade = between(dataNascimento, hoje).years

    return idade
}

fun String.transformarEmData(): LocalDate {
    val formatter = ofPattern("dd/MM/yyyy")
    val data = parse(this, formatter)

    return data
}