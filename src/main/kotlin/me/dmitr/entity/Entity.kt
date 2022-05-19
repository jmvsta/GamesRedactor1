package me.dmitr.entity

import org.bson.types.ObjectId

abstract class Entity {
    abstract var id: ObjectId
    abstract var name: String
    abstract var description: String
}