package ecommerce;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ProductTests extends BaseTest {
    @Test
    public void testGetProducts() {
        given()
        .when().get("/products")
        .then().statusCode(200).body("size()", greaterThan(0));
    }

    @Test
    public void testGetProductById() {
        given()
        .when().get("/products/1")
        .then().statusCode(200).body("id", equalTo(1));
    }

    @Test
    public void testCreateProduct() {
        String requestBody = "{"title":"Test Product","price":19.99,"description":"Test Description","image":"https://i.pravatar.cc","category":"electronics"}";

        given()
            .header("Content-Type", "application/json")
            .body(requestBody)
        .when().post("/products")
        .then().statusCode(200).body("title", equalTo("Test Product"));
    }
}