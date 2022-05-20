package me.dmitr.entity

import org.bson.types.ObjectId

abstract class AbstractEntity {
    abstract var id: ObjectId
    abstract var name: String
    abstract var description: String
}