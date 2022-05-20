package me.dmitr.entity

import me.dmitr.model.FigureType
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id

data class Figure (
  @Id
  override var id: ObjectId,
  override var name: String,
  override var description: String,
  val color: Short,
  val type: FigureType
) : AbstractEntity()