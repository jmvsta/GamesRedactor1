package me.dmitr.repository

import me.dmitr.data.Game
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface GamesRepository: MongoRepository<Game, ObjectId> {

//    fun findOneById(id: ObjectId): Game
    override fun deleteAll()

}
@Repository
interface FiguresRepository: MongoRepository<Game, ObjectId> {

//    fun findOneById(id: ObjectId): Game
    override fun deleteAll()

}