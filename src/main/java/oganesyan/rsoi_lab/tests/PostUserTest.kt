package oganesyan.rsoi_lab.tests

import oganesyan.rsoi_lab.model.PersonResponse
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PostUserTest {

    @Autowired
    private val restTemplate: TestRestTemplate? = null

    @Test
    @Throws(Exception::class)
    fun postUserTest() {
        this.restTemplate?.postForObject(
            "http://localhost:8080/api/v1/persons", mapOf(
                Pair("name", "Alex"),
                Pair("age", 19),
                Pair("address", "Home-28"),
                Pair("work", "solid work")
            ), PersonResponse::class.java
        )
    }
}
