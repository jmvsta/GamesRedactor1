package me.dmitr.entity

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

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
) : AbstractEntity()