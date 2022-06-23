package me.dmitr.data

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

abstract class Entity {
    abstract var id: ObjectId
    abstract var name: String?
    abstract var description: String?
}

data class Figure(
    @Id
    override var id: ObjectId,
    override var name: String?,
    override var description: String?,
    var color: Short,
    var type: FigureType
): Entity()

@Document(collection = "game")
data class Game(
    @Id
    override var id: ObjectId,
    override var name: String?,
    override var description: String?,
    var xSize: Short,
    var ySize: Short,
//  @DocumentReference(lazy=true)
    var figures: List<Figure>?
): Entity()

@Document(collection = "player")
data class Player(
    @Id
    override var id: ObjectId,
    override var name: String?,
    override var description: String?,
    var login: String,
    var inventory: Inventory?
): Entity()

data class Inventory(
    @Id
    override var id: ObjectId,
    override var name: String?,
    override var description: String?,
): Entity()
