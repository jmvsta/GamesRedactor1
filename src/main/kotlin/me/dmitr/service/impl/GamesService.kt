package me.dmitr.service.impl

import me.dmitr.entity.Game
import me.dmitr.service.AbstractService
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class GamesService (
        @Autowired override var repository: MongoRepository<Game, ObjectId>
) : AbstractService<Game, ObjectId>(repository) {

    override fun <Game> create(entity: Game): Mono<Game> {
        return Mono.empty()
    }

    override fun <Game> read(id: ObjectId): Mono<Game> {
//        val entityOptional = repository.findById(id)
//            entityOptional.ifPresentOrElse(() -> Mono.empty(), )
//            entityOptional.ifPresentOrElse({
//                return@ifPresentOrElse Mono.just(it)
//            }, {
//                return Mono.empty()
//            })
        return Mono.empty()
    }

    override fun <Game> readAll(): Flux<Game> {
        return Flux.empty()
    }

    override fun <Game> update(id: ObjectId, entity: Game): Mono<Game> {
        return Mono.empty()
    }

    override fun delete(id: ObjectId) {
    }

}
