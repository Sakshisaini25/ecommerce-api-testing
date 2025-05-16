package ecommerce;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UserTests extends BaseTest {
    @Test
    public void testGetUsers() {
        given()
        .when().get("/users")
        .then().statusCode(200).body("size()", greaterThan(0));
    }

    @Test
    public void testGetUserById() {
        given()
        .when().get("/users/1")
        .then().statusCode(200).body("id", equalTo(1));
    }
}