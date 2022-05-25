package me.dmitr.routing

import me.dmitr.data.Game
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class GamesHandler {

    @Qualifier("gamesRepository")
    @Autowired
    lateinit var repository: MongoRepository<Game, ObjectId>

    fun create(request: ServerRequest) : Mono<ServerResponse> {
        return Mono.empty()
    }

     fun read(request: ServerRequest) : Mono<ServerResponse> {
//        val entityOptional = repository.findById(id)
//            entityOptional.ifPresentOrElse(() -> Mono.empty(), )
//            entityOptional.ifPresentOrElse({
//                return@ifPresentOrElse Mono.just(it)
//            }, {
//                return Mono.empty()
//            })
        return Mono.empty()
    }

    fun readAll(request: ServerRequest) : Mono<ServerResponse> {
        return Mono.empty()
    }

    fun update(request: ServerRequest) : Mono<ServerResponse> {
        return Mono.empty()
    }

    fun delete(request: ServerRequest) : Mono<ServerResponse> {
        return Mono.empty()
    }


}

@Component
class FiguresHandler {

    @Qualifier("figuresRepository")
    @Autowired
    lateinit var repository: MongoRepository<Game, ObjectId>

    fun create(request: ServerRequest) : Mono<ServerResponse> {
        return Mono.empty()
    }

     fun read(request: ServerRequest) : Mono<ServerResponse> {
//        val entityOptional = repository.findById(id)
//            entityOptional.ifPresentOrElse(() -> Mono.empty(), )
//            entityOptional.ifPresentOrElse({
//                return@ifPresentOrElse Mono.just(it)
//            }, {
//                return Mono.empty()
//            })
        return Mono.empty()
    }

    fun readAll(request: ServerRequest) : Mono<ServerResponse> {
        return Mono.empty()
    }

    fun update(request: ServerRequest) : Mono<ServerResponse> {
        return Mono.empty()
    }

    fun delete(request: ServerRequest) : Mono<ServerResponse> {
        return Mono.empty()
    }


}