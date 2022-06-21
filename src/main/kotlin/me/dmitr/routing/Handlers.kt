package me.dmitr.routing

import me.dmitr.data.Game
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class GamesHandler {

    @Qualifier("gamesRepository")
    @Autowired
    lateinit var gamesRepository : ReactiveMongoRepository<Game, ObjectId>

    fun create(request: ServerRequest) : Mono<ServerResponse> {
        return Mono.empty()
    }

     fun read(request: ServerRequest) : Mono<ServerResponse> {
         return ServerResponse
             .ok()
             .contentType(MediaType.APPLICATION_JSON)
             .body(gamesRepository.findById(ObjectId(request.pathVariable("id"))), Game::class.java)
     }

    fun readAll(request: ServerRequest) : Mono<ServerResponse> {
        return ServerResponse
            .ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(gamesRepository.findAll(), Game::class.java)
    }

    fun update(request: ServerRequest) : Mono<ServerResponse> {
        return Mono.empty()
    }

    fun delete(request: ServerRequest) : Mono<ServerResponse> {
        return ServerResponse
            .ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(gamesRepository.deleteById(ObjectId(request.pathVariable("id"))), Game::class.java)
    }

}

@Component
class FiguresHandler {
    fun create(request: ServerRequest) : Mono<ServerResponse> {
        return Mono.empty()
    }

     fun read(request: ServerRequest) : Mono<ServerResponse> {
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