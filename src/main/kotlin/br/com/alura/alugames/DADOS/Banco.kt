package br.com.alura.alugames.DADOS

import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

object Banco {
//    var enderecoPostgres="jdbc:postgresql://localhost:5432/"
//    var enderecoMySql="jdbc:mysql://localhost:3306/"
//    var projeto1="alugames"
//        fun obterConexao(): Connection? {
//            return try {
//                //Para endereço mySql o User é "root", para PostGres o User é "postgres"
//                DriverManager.getConnection(enderecoMySql+projeto1,"root", "@Pi141592")
//            } catch (e: SQLException) {
//                e.printStackTrace()
//                null
//            }
//        }

    fun getEntityManager():EntityManager {
        val factory:EntityManagerFactory=Persistence.createEntityManagerFactory("alugamesPostGres")
        return factory.createEntityManager()
    }
}