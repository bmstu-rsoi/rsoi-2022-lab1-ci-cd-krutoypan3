package oganesyan.rsoi_lab.tests

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GetAllUserTest {

    @Autowired
    private val restTemplate: TestRestTemplate? = null

    @Test
    @Throws(Exception::class)
    fun getAllUserTest() {
        assertThat(
            this.restTemplate?.getForObject(
                "http://localhost:8080/api/v1/persons",
                String::class.java
            )
        )
        println("Persons: " + this.restTemplate?.getForObject(
            "http://localhost:8080/api/v1/persons",
            String::class.java
        ))
    }
}