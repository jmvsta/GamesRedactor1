package me.dmitr

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GamesRedactor

fun main(args: Array<String>) {
    runApplication<GamesRedactor>(*args)
}