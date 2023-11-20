package br.com.alura.alugames.DADOS

import br.com.alura.alugames.modelo.Jogo

class jogosDAO {
    fun getJogos(): List<Jogo> {
        val manager = Banco.getEntityManager()
        try {
            val query = manager.createQuery("FROM Jogo", Jogo::class.java)
            return query.resultList
        } finally {
            manager.close()
        }
    }
}
//    fun getJogos():List<Jogo>{
//        val conexao= Banco.obterConexao()
//        val listaJogos= mutableListOf<Jogo>()
//        if (conexao!=null) {
//            try {
//                val statement = conexao.createStatement()
//                val result=statement.executeQuery("SELECT * FROM jogos2")
//                while (result.next()) {
//                    val id=result.getInt("id")
//                    val titulo=result.getString("titulo")
//                    val capa=result.getString("capa")
//                    val descricao=result.getString("descricao")
//                    val preco=result.getDouble("preco")
//
//                    val jogo= Jogo(titulo, capa, preco, descricao,id)
//                    listaJogos.add(jogo)
//                }
//                statement.close()
//            } finally {
//                conexao.close()
//            }
//        }
//        return listaJogos
//    }
//
//    fun adicionarJogo(jogo: Jogo) {
//        val conexao= Banco.obterConexao()
//        if (conexao!=null) {
//            try {
//                val capa=jogo.capa
//                val descricao=jogo.descricao
//                val preco=jogo.preco
//                val titulo=jogo.titulo
//
//                var insertSql="INSERT INTO JOGOS2(TITULO, CAPA, PRECO, DESCRICAO) VALUES (?, ?, ?, ?)"
//                println(insertSql)
//                val statement = conexao.prepareStatement(insertSql)
//                statement.setString(1,jogo.titulo)
//                statement.setString(2,jogo.capa)
//                statement.setDouble(3, jogo.preco!!)
//                statement.setString(4,jogo.descricao)
//
//                statement.executeUpdate()
//                statement.close()
//            } finally {
//                conexao.close()
//            }
//        }
//    }
//}