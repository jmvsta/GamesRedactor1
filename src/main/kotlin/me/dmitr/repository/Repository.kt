package me.dmitr.repository

import me.dmitr.data.Figure
import me.dmitr.data.Game
import me.dmitr.data.Player
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface GamesRepository: ReactiveMongoRepository<Game, ObjectId>

@Repository
interface FiguresRepository: ReactiveMongoRepository<Figure, ObjectId>

@Repository
interface PlayersRepository: ReactiveMongoRepository<Player, ObjectId>