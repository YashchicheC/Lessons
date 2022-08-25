import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ApiTest extends BaseTest
{
    @Test
    public void createAndGetStudent()
    {
        Response studentCreateResponse = RestAssured.given()
                .body(new StudentData("Volodymyr", "Holovach"))
                .post("/students");

        studentCreateResponse.then().statusCode(200);
        Student student = studentCreateResponse.as(Student.class);
    }
}
