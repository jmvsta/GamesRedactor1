package me.dmitr.data

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

abstract class Entity {
    abstract var id: ObjectId
    abstract var name: String
    abstract var description: String
}

data class Figure (
    @Id
    override var id: ObjectId,
    override var name: String,
    override var description: String,
    val color: Short,
    val type: FigureType
) : Entity()

@Document(collection = "game")
data class Game (
    @Id
    override var id: ObjectId,
    override var name: String,
    override var description: String,
    val xSize: Short,
    val ySize: Short,
//  @DocumentReference(lazy=true)
    val figures: List<Figure>
) : Entity()