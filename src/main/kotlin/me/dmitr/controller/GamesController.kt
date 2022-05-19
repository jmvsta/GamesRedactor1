package me.dmitr.controller

import me.dmitr.entity.Game
import me.dmitr.model.Request
import me.dmitr.repository.GamesRepository
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/games")
class GamesController(
    private val gamesRepository: GamesRepository
)   {

    @Autowired
    private val mt: MongoTemplate? = null

    @GetMapping
    fun getAllGames(): ResponseEntity<List<Game>> {
        val games = gamesRepository.findAll()
        return ResponseEntity.ok(games)
    }

    @GetMapping("/{id}")
    fun getOneGame(@PathVariable("id") id: String): ResponseEntity<Game> {
        val game = gamesRepository.findOneById(ObjectId(id))
        return ResponseEntity.ok(game)
    }

    @PostMapping
    fun createGame(@RequestBody request: Request<Game>): ResponseEntity<Game> {
        val game = gamesRepository.save(Game(
            id = request.entity.id,
            name = request.entity.name,
            description = request.entity.description,
            xSize = request.entity.xSize,
            ySize = request.entity.ySize,
            figures = listOf()
        ))
        return ResponseEntity(game, HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun updateGame(@RequestBody request: Request<Game>, @PathVariable("id") id: String): ResponseEntity<Game> {
        val game = gamesRepository.findOneById(ObjectId(id))
        val updatedGame = gamesRepository.save(Game(
            id = game.id,
            name = request.entity.name,
            description = request.entity.description,
            xSize = request.entity.xSize,
            ySize = request.entity.ySize,
            figures = request.entity.figures
        ))
        return ResponseEntity.ok(updatedGame)
    }

    @DeleteMapping("/{id}")
    fun deleteGame(@PathVariable("id") id: String): ResponseEntity<Unit> {
        gamesRepository.deleteById(id)
        return ResponseEntity.noContent().build()
    }

}
