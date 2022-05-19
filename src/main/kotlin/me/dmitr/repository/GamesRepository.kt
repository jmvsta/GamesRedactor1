package me.dmitr.repository

import me.dmitr.entity.Game
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface GamesRepository: MongoRepository<Game, String> {

    fun findOneById(id: ObjectId): Game
    override fun deleteAll()

}