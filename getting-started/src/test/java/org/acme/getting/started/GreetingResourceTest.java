package org.acme.getting.started;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import java.util.UUID;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/hello") //cuando recibas el endpoint /hello
                .then()                  //entonces...
                .statusCode(200)         //valida con los códigos de errores http
                .body(is("hello"));  //que devuelva lo especificado
    }

    @Test
    public void testGreetingEndpoint() {
        String uuid = UUID.randomUUID().toString();
        given()
                .pathParam("name", uuid)                //se utiliza para cuando en el endpoint tiene algún parámetro ('tipo', parámetro)
                .when().get("/hello/greeting/{name}")   //cuando recibas este endpoint
                .then()                                    //entonces...
                .statusCode(200)                           //valida con los códigos de errores http
                .body(is("hello " + uuid));           // que devuelva el string + el parámetro introducido
    }

}