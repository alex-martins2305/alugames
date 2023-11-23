package br.com.alura.alugames.dados

import br.com.alura.alugames.modelo.Jogo
import org.hibernate.type.EntityType
import javax.persistence.EntityManager

abstract class DAO<TModel, TEntity>(protected val manager:EntityManager, protected val entityType:class.TEntity) {
    abstract fun toEntity(Object: TModel):TEntity
    abstract fun toModel(entity:TEntity):TModel
    open fun getLista(): List<TModel>{
        val entityType=JogoEntity::class.java
        val query = manager.createQuery("FROM ${entityType.simpleName}",entityType )
        return query.resultList.map { entity ->toModel(entity)
        }
    }
    open fun adicionar(Object:TModel){
        //val entity=JogoEntity(Jogo.titulo, Jogo.capa, Jogo.preco, Jogo.descricao, Jogo.id)
        =JogoEntity(Jogo.titulo, Jogo.capa, Jogo.preco, Jogo.descricao, Jogo.id)

        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }
    open fun deleta(Object:TModel){

    }
    open fun update(Object:TModel) {

    }


}