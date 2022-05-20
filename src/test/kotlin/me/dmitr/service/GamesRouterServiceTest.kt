package me.dmitr.service

import me.dmitr.entity.Game
import me.dmitr.repository.GamesRepository
import me.dmitr.service.impl.GamesService
import org.bson.types.ObjectId
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Import
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.reactive.server.WebTestClient


//@RunWith(
//    SpringRunner.class)
@WebFluxTest
@Import(GamesRouter::class)
//@ContextConfiguration(classes = {GamesRouter.class})
class GamesRouterServiceTest (@Autowired private val client: WebTestClient) {

    @MockBean
    private lateinit var service: GamesService

    @Autowired
    private val context: ApplicationContext? = null

    private val webTestClient = context?.let { WebTestClient.bindToApplicationContext(it).build() }

//    @BeforeAll
//    fun setUp() {
//        webTestClient
//    }

//    @Test
//    fun testRoot() = testApplication {
//        val response = client.get("/")
//        assertEquals(HttpStatusCode.OK, response.status)
//        assertEquals("Hello, world!", response.bodyAsText())
//    }

    //    @Test
//    fun testGetUserById() {
////        val user: User = User.builder().id(1).name("ABC").email("abc@xyz.com").build()
////        val UserMono: Mono<User> = Mono.just<User>(user)
//        `when` (gamesService.read(any(ObjectId.class))).thenReturn()
//        webTestClient!!.get()
//            .uri("/users/1")
//            .accept(MediaType.APPLICATION_JSON)
//            .exchange()
//            .expectStatus().isOk
//            .expectBody(User::class.java)
//            .value { userResponse ->
//                Assertions.assertThat(userResponse.getId()).isEqualTo(1)
//                Assertions.assertThat(userResponse.getName()).isEqualTo("ABC")
//                Assertions.assertThat(userResponse.getEmail()).isEqualTo("abc@xyz.com")
//            }
//    }
    @Test
    fun testGetGameById() {
//        every {
//            repository.findAll()
//        } returns flow {
//            emit(aCat())
//            emit(anotherCat())
//        }

        client
            .get()
            .uri("/games/")
            .exchange()
            .expectStatus()
            .isOk
            .expectBodyList<CatDto>()
            .hasSize(2)
            .contains(aCat().toDto(), anotherCat().toDto())
    }


}

//@SpringBootApplication
//class MockMvcApplication