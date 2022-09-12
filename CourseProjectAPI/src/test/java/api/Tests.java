package api;

import com.fasterxml.jackson.databind.util.JSONPObject;
import io.restassured.RestAssured;
import io.restassured.config.HeaderConfig;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class Tests {
    private final static String URL = "http://www.robotdreams.karpenko.cc";

    @Test
    public void userPostTest1() {

        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpec200());
        String username = "FirstUser3";
        String password = "Password3";
        UserTest1 newUser = new UserTest1(username, password);
        UserTest1 successCallback = given()
                .body(newUser)
                .log().all()
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
    @Test
    public void studentPostTest3(){
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseUniqueCode(422));
        String first_name = "FirstStudent";
        String last_name = "StudentLastName";
        StudentTest3 student = new StudentTest3(first_name, last_name);

        RestAssured.given()
                .body(student)
                .when()
                .post("/students").then().statusCode(200);
        Response response = RestAssured.given()
                .when()
                .get();

       /* StudentTest3Response response = given()
                .body(student)
                .log().all()
                .when()
                .post("/students")
                .then().log().all()
                .extract().as(StudentTest3Response.class);
        JSONPObject joTokenREsponse = new JSONPObject(response.as)
        System.out.println(response.getFirst_name());*/
      /* Assert.assertNotNull(response.getId());
        Assert.assertNotNull(response.getFirst_name());
        Assert.assertNotNull(response.getLast_name());*/

    }
}

