package me.dmitr.model

import me.dmitr.entity.Entity

data class Request<T: Entity> (
    val entity: T
)
