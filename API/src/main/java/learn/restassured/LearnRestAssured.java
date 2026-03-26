package learn.restassured;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LearnRestAssured {
    @Test
    public void checkResponseTime() {
        // Send GET request
        long responseTime = given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .when()
                .get("/posts/1")
                .then()
                .extract().response().time();

        // Print response time in milliseconds
        System.out.println("Response time: " + responseTime + " ms");

        // Assert response time is under 2 seconds
        Assert.assertTrue(responseTime < 1000, "Response time exceeded 1 seconds!");
    }


}
