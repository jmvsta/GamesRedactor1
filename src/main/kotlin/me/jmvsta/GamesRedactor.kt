package me.jmvsta

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties
class GamesRedactor

fun main(args: Array<String>) {
    runApplication<GamesRedactor>(*args)
}