import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class BaseTest {
    private final String userNamePrefix = "testapiuser1";
    private final String password = "testapipass";
    private String userName;
    private String sessionToken;


    @BeforeTest
    public void setUp() {
        RestAssured.baseURI = "http://www.robotdreams.karpenko.cc/";
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();

        userName = userNamePrefix + randomAlphanumeric(5);
        JSONObject jsonObjUser = new JSONObject();
        jsonObjUser.put("username", userName);
        jsonObjUser.put("password", password);

        RestAssured.given()
                .body(jsonObjUser.toString())
                .when()
                .post("/user").then().statusCode(200);

        Response sessionResponse = RestAssured.given()
                .queryParam("username", userName)
                .queryParam("password", password)
                .when()
                .get("/login");
        sessionResponse.then().statusCode(200);

        JSONObject joTokenRespone = new JSONObject(sessionResponse.asString());
        sessionToken = joTokenRespone.getString("session_token");
        String str = joTokenRespone.getString("username");
        System.out.println(sessionToken + str);

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .addHeader("user-token", sessionToken)
                .build();
    }
}
