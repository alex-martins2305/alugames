package br.com.alura.alugames.dados

import br.com.alura.alugames.modelo.Gamer
import javax.persistence.EntityManager

class GamerDAO(val manager: EntityManager) {
    fun getGamers(): List<Gamer> {

        val query = manager.createQuery("FROM GamerEntity", GamerEntity::class.java)
        return query.resultList.map { entity ->
            Gamer(entity.nome, entity.email, entity.dataNascimento, entity.usuario, entity.id)}

    }

    fun adicionarGamer(gamer: Gamer){
        val entity=GamerEntity(gamer.nome, gamer.email, gamer.dataNascimento!!, gamer.usuario!!, gamer.id)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }
    fun deletaGamer(gamer: Gamer) {
        val gameDel=manager.find(GamerEntity::class.java, gamer.id)
        manager.transaction.begin()
        manager.remove(gameDel)
        manager.transaction.commit()
    }

    fun updateGamer(gamer: Gamer) {
        val gamerUpd=manager.find(GamerEntity::class.java, gamer.id)
        gamerUpd.nome="teste23"
        manager.transaction.begin()
        manager.merge(gamerUpd)
        manager.transaction.commit()
    }

}

