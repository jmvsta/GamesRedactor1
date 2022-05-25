package me.dmitr.routing

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.router

@Configuration
class GamesRouterConfig(private val handler: GamesHandler) {

    @Bean
    fun gamesRouter() = router {
        "/api".nest {
            POST("/games/", handler::create)
            GET("/games/{id}", handler::read)
            GET("/games/", handler::readAll)
            PUT("/games/", handler::update)
            DELETE("/games/{id}", handler::delete)
        }
    }
}

@Configuration
class FiguresRouterConfig(private val handler: FiguresHandler) {

    @Bean
    fun figuresRouter() = router {
        "/api".nest {
            POST("/figures/", handler::create)
            GET("/figures/{id}", handler::read)
            GET("/figures/", handler::readAll)
            PUT("/figures/", handler::update)
            DELETE("/figures/{id}", handler::delete)
        }
    }
}