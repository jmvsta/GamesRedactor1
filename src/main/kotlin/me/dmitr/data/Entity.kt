package me.dmitr.data

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

abstract class Entity {
    abstract var id: ObjectId
}

data class Figure(
    @Id
    override var id: ObjectId,
    var name: String,
    var color: Short,
    var type: FigureType
): Entity()

@Document(collection = "game")
data class Game(
    @Id
    override var id: ObjectId,
    var xSize: Short,
    var ySize: Short,
    var figures: List<Figure>?
): Entity()

@Document(collection = "player")
data class Player(
    @Id
    override var id: ObjectId,
    var login: String,
    var inventory: Inventory?
): Entity()

data class Inventory(
    @Id
    override var id: ObjectId
): Entity()
