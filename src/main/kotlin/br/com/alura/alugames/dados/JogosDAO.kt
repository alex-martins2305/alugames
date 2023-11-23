package br.com.alura.alugames.dados

import br.com.alura.alugames.modelo.Jogo
import javax.persistence.EntityManager
class JogosDAO(manager: EntityManager):DAO<Jogo, JogoEntity> (manager){
    override fun toEntity(Object: Jogo):JogoEntity {
        return JogoEntity(Object.titulo, Object.capa, Object.preco, Object.descricao, Object.id)
    }

    override fun toModel(entity: JogoEntity): Jogo {
       return Jogo(entity.titulo, entity.capa, entity.preco, entity.descricao!!, entity.id)
    }
    override fun getLista(): List<Jogo> {

    }

    override fun adicionar(Jogo:Jogo){

    }
    override fun deleta(jogo: Jogo) {
        val jogoDel=manager.find(Jogo::class.java, jogo.id)
        manager.transaction.begin()
        manager.remove(jogoDel)
        manager.transaction.commit()
    }

    override fun update(jogo: Jogo) {
        val jogoUpd=manager.find(Jogo::class.java, jogo.id)
        jogoUpd.titulo="teste23"
        manager.transaction.begin()
        manager.merge(jogoUpd)
        manager.transaction.commit()
    }

}

