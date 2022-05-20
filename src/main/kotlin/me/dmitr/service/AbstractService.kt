package me.dmitr.service

import me.dmitr.entity.AbstractEntity
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

abstract class AbstractService<T: AbstractEntity, R> (
    open var repository: MongoRepository<T, R>
) {

//    fun <T> getOne(id: String): Mono<T> {
//        var entityOptional = repository.findOne(ObjectId(id))
//
//        return Mono.just()
//    }
    abstract fun <T> create(entity: T): Mono<T>

    abstract fun <T> read(id: R): Mono<T>

    abstract fun <T> readAll(): Flux<T>

    abstract fun <T> update(id: R, entity: T): Mono<T>

    abstract fun delete(id: R)

}