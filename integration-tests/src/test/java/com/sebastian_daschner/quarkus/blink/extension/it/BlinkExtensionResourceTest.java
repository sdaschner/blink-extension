package com.sebastian_daschner.quarkus.blink.extension.it;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class BlinkExtensionResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/blink-extension")
                .then()
                .statusCode(200)
                .body(is("Hello blink-extension"));
    }
}
