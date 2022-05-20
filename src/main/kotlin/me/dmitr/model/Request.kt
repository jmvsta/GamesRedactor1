package me.dmitr.model

import me.dmitr.entity.AbstractEntity

data class Request<T: AbstractEntity> (
    val entity: T
)
