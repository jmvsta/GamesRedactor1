package me.dmitr.routing

import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import me.dmitr.data.Figure
import me.dmitr.data.FigureType.*
import me.dmitr.data.Game
import org.bson.types.ObjectId
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.context.annotation.Import
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.web.reactive.function.server.ServerResponse


@WebFluxTest
@Import(GamesRouterConfig::class, GamesHandler::class)
class GamesRouterTest(@Autowired private val client: WebTestClient) {

    @MockkBean
    private lateinit var handler : GamesHandler

    private fun aGame() = Game (
            id = ObjectId("542c2b97bac0505474109b41"),
            name = "name",
            description = "description",
            xSize = 8,
            ySize = 8,
            figures = listOf()
        )

    @Test
    fun whenGetAllCalled_thenOk() {
        every {
            handler.readAll(any())
        } answers  {
            ServerResponse.ok().bodyValue(aGame())
        }

        client.get()
            .uri("/api/games/")
            .exchange()
            .expectStatus()
            .isOk
    }

    @Test
    fun whenGetCalled_thenOk() {
        every {
            handler.read(any())
        } answers  {
            ServerResponse.ok().bodyValue(aGame())
        }

        client.get()
            .uri("/api/games/542c2b97bac0505474109b41")
            .exchange()
            .expectStatus()
            .isOk
    }

    @Test
    fun whenPostCalled_thenOk() {
        every {
            handler.create(any())
        } answers  {
            ServerResponse.ok().bodyValue(aGame())
        }

        client.post()
            .uri("/api/games/")
            .exchange()
            .expectStatus()
            .isOk
    }

    @Test
    fun whenPutCalled_thenOk() {
        every {
            handler.update(any())
        } answers  {
            ServerResponse.ok().bodyValue(aGame())
        }

        client.put()
            .uri("/api/games/")
            .exchange()
            .expectStatus()
            .isOk
    }

    @Test
    fun whenDeleteCalled_thenOk() {
        every {
            handler.delete(any())
        } answers  {
            ServerResponse.ok().bodyValue(aGame())
        }

        client.delete()
            .uri("/api/games/542c2b97bac0505474109b41")
            .exchange()
            .expectStatus()
            .isOk
    }

}

@WebFluxTest
@Import(FiguresRouterConfig::class, FiguresHandler::class)
class FiguresRouterTest(@Autowired private val client: WebTestClient) {

    @MockkBean
    private lateinit var handler : FiguresHandler

    private fun aFigure() = Figure (
        id = ObjectId("542c2b97bac0505474109b41"),
        name = "name",
        description = "description",
        color = 1,
        type = CHECKER
    )

    @Test
    fun whenGetAllCalled_thenOk() {
        every {
            handler.readAll(any())
        } answers  {
            ServerResponse.ok().bodyValue(aFigure())
        }

        client.get()
            .uri("/api/figures/")
            .exchange()
            .expectStatus()
            .isOk
    }

    @Test
    fun whenGetCalled_thenOk() {
        every {
            handler.read(any())
        } answers  {
            ServerResponse.ok().bodyValue(aFigure())
        }

        client.get()
            .uri("/api/figures/542c2b97bac0505474109b41")
            .exchange()
            .expectStatus()
            .isOk
    }

    @Test
    fun whenPostCalled_thenOk() {
        every {
            handler.create(any())
        } answers  {
            ServerResponse.ok().bodyValue(aFigure())
        }

        client.post()
            .uri("/api/figures/")
            .exchange()
            .expectStatus()
            .isOk
    }

    @Test
    fun whenPutCalled_thenOk() {
        every {
            handler.update(any())
        } answers  {
            ServerResponse.ok().bodyValue(aFigure())
        }

        client.put()
            .uri("/api/figures/")
            .exchange()
            .expectStatus()
            .isOk
    }

    @Test
    fun whenDeleteCalled_thenOk() {
        every {
            handler.delete(any())
        } answers  {
            ServerResponse.ok().bodyValue(aFigure())
        }

        client.delete()
            .uri("/api/figures/542c2b97bac0505474109b41")
            .exchange()
            .expectStatus()
            .isOk
    }

}