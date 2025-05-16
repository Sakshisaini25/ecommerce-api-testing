package ecommerce;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.util.Properties;

public class BaseTest {
    @BeforeClass
    public void setup() throws Exception {
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/test/resources/config.properties"));
        RestAssured.baseURI = prop.getProperty("baseURI");
    }
}