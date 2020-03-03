package com.redbend;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class VehicleResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/vehicles")
          .then()
             .statusCode(200);
    }

}