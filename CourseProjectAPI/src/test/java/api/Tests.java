package api;

import io.restassured.RestAssured;
import io.restassured.config.HeaderConfig;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Tests {
    private final static String URL = "http://www.robotdreams.karpenko.cc";

    @Test
    public void userPostTest1() {
        RestAssured.reset();
        RestAssured.config = RestAssured.config.headerConfig(HeaderConfig.headerConfig().overwriteHeadersWithName("username"));
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpec200());
        String username = "FirstUser3";
        String password = "Password3";
        UserTest1 newUser = new UserTest1(username, password);
        UserTest1 successCallback = given()
                .body(newUser)
                .when()
                .post("/user")
                .then().log().all()
                .extract().as(UserTest1.class);

        Assert.assertNotNull(successCallback.getUsername());
        Assert.assertNotNull(successCallback.getPassword());

        Assert.assertEquals(username, successCallback.getUsername());
        Assert.assertEquals(password, successCallback.getPassword());
    }

    @Test
    public void userGetTest2() {
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseUniqueCode(200));
        String username = "FirstUser3";
        UserTest2 successCallback = given()
               // .queryParam(username, password)
                .when()
                .get("/login?username=FirstUser3&password=Password3")
                .then().log().all()
                .extract().as(UserTest2.class);
        Assert.assertEquals(username, successCallback.getUsername());
    }
}

