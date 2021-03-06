package com.example.restservice.integrationtest;

import io.restassured.RestAssured;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestServiceTest {
    @LocalServerPort
    String port;

    @Test
    @SneakyThrows
    void getResponseTest() {
        RestAssured
                .given()
                .baseUri("http://localhost:" + port)
                .when()
                .get("/greeting")
                .then()
                .statusCode(200);
    }
}
