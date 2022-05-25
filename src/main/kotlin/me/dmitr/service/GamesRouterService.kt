//package me.dmitr.service
//
//import me.dmitr.service.impl.GamesService
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.stereotype.Service
//
//
//@Service
//class GamesRouterService(@Autowired private val gamesService: GamesService) {
//
////    @Autowired
////    private val mt: MongoTemplate? = null
//
////    @Bean
////    fun gamesRouter() = router {
////        "/api".nest {
////            (POST("/games/")) {
////                ok().body(gamesService.create(it))
////            }
////            (GET("/games/{id}")) {
////                ok().body(gamesService.read(ObjectId(it.pathVariable("id"))))
////            }
////            (GET("/games/")) {
////                ok().body(gamesService.readAll())
////            }
////            (PUT("/games/")) {
////                ok().body(gamesService.update(ObjectId(it.pathVariable("id")), it))
////            }
////            (DELETE("/games/{id}")) {
////                gamesService.delete(ObjectId(it.pathVariable("id")))
////                ok().body(Mono.empty())
////            }
////        }
////    }
//
////    @GetMapping
////    fun getAllGames(): ResponseEntity<List<Game>> {
////        val games = gamesRepository.findAll()
////        return ResponseEntity.ok(games)
////    }
////
////    @GetMapping("/{id}")
////    fun getOneGame(@PathVariable("id") id: String): ResponseEntity<Game> {
////        val game = gamesRepository.findOneById(ObjectId(id))
////        return ResponseEntity.ok(game)
////    }
////
////    @PostMapping
////    fun createGame(@RequestBody request: Request<Game>): ResponseEntity<Game> {
////        val game = gamesRepository.save(Game(
////            id = request.entity.id,
////            name = request.entity.name,
////            description = request.entity.description,
////            xSize = request.entity.xSize,
////            ySize = request.entity.ySize,
////            figures = listOf()
////        ))
////        return ResponseEntity(game, HttpStatus.CREATED)
////    }
////
////    @PutMapping("/{id}")
////    fun updateGame(@RequestBody request: Request<Game>, @PathVariable("id") id: String): ResponseEntity<Game> {
////        val game = gamesRepository.findOneById(ObjectId(id))
////        val updatedGame = gamesRepository.save(Game(
////            id = game.id,
////            name = request.entity.name,
////            description = request.entity.description,
////            xSize = request.entity.xSize,
////            ySize = request.entity.ySize,
////            figures = request.entity.figures
////        ))
////        return ResponseEntity.ok(updatedGame)
////    }
////
////    @DeleteMapping("/{id}")
////    fun deleteGame(@PathVariable("id") id: String): ResponseEntity<Unit> {
////        gamesRepository.deleteById(id)
////        return ResponseEntity.noContent().build()
////    }
//
//}
