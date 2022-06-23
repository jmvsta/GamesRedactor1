package me.dmitr.routing

import me.dmitr.data.Figure
import me.dmitr.data.Game
import me.dmitr.data.Player
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
    lateinit var gamesRepository: ReactiveMongoRepository<Game, ObjectId>

    fun create(request: ServerRequest): Mono<ServerResponse> {
        return request.bodyToMono(Game::class.java)
            .flatMap { body -> ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(gamesRepository.save(body), Game::class.java)
            }
    }

     fun read(request: ServerRequest): Mono<ServerResponse> {
         return ServerResponse
             .ok()
             .contentType(MediaType.APPLICATION_JSON)
             .body(gamesRepository.findById(ObjectId(request.pathVariable("id"))), Game::class.java)
     }

    fun readAll(request: ServerRequest): Mono<ServerResponse> {
        return ServerResponse
            .ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(gamesRepository.findAll(), Game::class.java)
    }

    fun update(request: ServerRequest): Mono<ServerResponse> {
        return request.bodyToMono(Game::class.java)
            .flatMap { body -> ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(gamesRepository.save(body), Game::class.java)
            }
    }

    fun delete(request: ServerRequest): Mono<ServerResponse> {
        return ServerResponse
            .ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(gamesRepository.deleteById(ObjectId(request.pathVariable("id"))), Game::class.java)
    }

}

@Component
class FiguresHandler {

    @Qualifier("figuresRepository")
    @Autowired
    lateinit var figuresRepository: ReactiveMongoRepository<Figure, ObjectId>
    fun create(request: ServerRequest): Mono<ServerResponse> {
        return request.bodyToMono(Figure::class.java)
            .flatMap { body -> ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(figuresRepository.save(body), Figure::class.java)
            }
    }

     fun read(request: ServerRequest): Mono<ServerResponse> {
         return ServerResponse
             .ok()
             .contentType(MediaType.APPLICATION_JSON)
             .body(figuresRepository.findById(ObjectId(request.pathVariable("id"))), Figure::class.java)
    }

    fun readAll(request: ServerRequest): Mono<ServerResponse> {
        return ServerResponse
            .ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(figuresRepository.findAll(), Figure::class.java)
    }

    fun update(request: ServerRequest): Mono<ServerResponse> {
        return request.bodyToMono(Figure::class.java)
            .flatMap { body -> ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(figuresRepository.save(body), Figure::class.java)
            }
    }

    fun delete(request: ServerRequest): Mono<ServerResponse> {
        return ServerResponse
            .ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(figuresRepository.deleteById(ObjectId(request.pathVariable("id"))), Figure::class.java)
    }

}

@Component
class PlayersHandler {

    @Qualifier("playersRepository")
    @Autowired
    lateinit var playersRepository: ReactiveMongoRepository<Player, ObjectId>

    fun create(request: ServerRequest): Mono<ServerResponse> {
        return request.bodyToMono(Player::class.java)
            .flatMap { body -> ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(playersRepository.save(body), Player::class.java)
            }
    }

    fun read(request: ServerRequest): Mono<ServerResponse> {
        return ServerResponse
            .ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(playersRepository.findById(ObjectId(request.pathVariable("id"))), Player::class.java)
    }

    fun readAll(request: ServerRequest): Mono<ServerResponse> {
        return ServerResponse
            .ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(playersRepository.findAll(), Player::class.java)
    }

    fun update(request: ServerRequest): Mono<ServerResponse> {
        return request.bodyToMono(Player::class.java)
            .flatMap { body -> ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(playersRepository.save(body), Player::class.java)
            }
    }

    fun delete(request: ServerRequest): Mono<ServerResponse> {
        return ServerResponse
            .ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(playersRepository.deleteById(ObjectId(request.pathVariable("id"))), Player::class.java)
    }

}