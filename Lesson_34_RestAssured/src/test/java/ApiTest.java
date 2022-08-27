import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class ApiTest extends BaseTest
{
    @Test (priority = 1)
    public void postRequestFirstTwoStudent()
    {
        Response studentCreateResponse = RestAssured.given()
                .body(new StudentData("Volodymyr", "Holovach"))
                .post("/students");

        studentCreateResponse.then().statusCode(200);
        Student student = studentCreateResponse.as(Student.class);

        Response studentGetResponse = RestAssured.get("/students/{id}", student.id);
        Student receiveStudent = studentGetResponse.as(Student.class);
        Assert.assertEquals(receiveStudent.firstName, "Volodymyr");
        Assert.assertEquals(receiveStudent.lastName, "Holovach");

        //<-------------------------------------------------------------------------------------->

        Response studentCreateResponse2 = RestAssured.given()
                .body(new StudentData("Two", "Twost"))
                .post("/students");

        studentCreateResponse2.then().statusCode(200);
        Student student2 = studentCreateResponse2.as(Student.class);

        Response studentGetResponse2 = RestAssured.get("/students/{id}", student2.id);
        Student receiveStudent2 = studentGetResponse2.as(Student.class);
        Assert.assertEquals(receiveStudent2.firstName, "Two");
        Assert.assertEquals(receiveStudent2.lastName, "Twost");

        //<-------------------------------------------------------------------------------------->

        Student[] allStudents = RestAssured.get("/students").as(Student[].class);
        Assert.assertEquals(allStudents.length, 2);
        System.out.println(Arrays.asList(allStudents));
    }
    @Test (priority = 2)
    public void postRequestThirdStudent() //----------третий студент с отправкой post
    {
        RestAssured.given()
                .body(new StudentData("Three", "Threest"))
                .post("/students")
                .then().statusCode(200);
        Student[] allStudents = RestAssured.get("/students").as(Student[].class);
        Assert.assertEquals(allStudents.length, 3);
        System.out.println(Arrays.asList(allStudents));
    }
    @Test (priority = 3)
    public void postRequestCreateGroup()
    {
        List<Student> allStudents = Arrays.asList(RestAssured.get("/students")//----->забираем всех студентов из /students
               .then().statusCode(200)
               .extract().as(Student[].class)
        );

    List<Integer> studentIds = allStudents.stream().map(student -> student.id).toList();//------>непонятная штука для map, так как список нельзя передать/ Берем только ID

    Response response = RestAssured.given()
            .body(new StudentToGroup("NewGroup", studentIds))
            .post("/groups");
    response.then().statusCode(200);
    Assert.assertEquals(response.as(Group.class).name, "NewGroup");
    Assert.assertEquals(response.as(Group.class).students.size(), 3);

    allStudents = Arrays.asList(
            RestAssured.given()
                    .queryParam("last_name", "ch")
                    .when().get("/students")
                    .then().statusCode(200)
                    .extract().as(Student[].class)
    );

    studentIds = allStudents.stream().map(student -> student.id).toList();

    Group newGroup = RestAssured
            .given().body(new StudentToGroup("HomeTask", studentIds))
            .post("/groups")
            .then().statusCode(200)
            .body("name", equalTo("HomeTask"))
            .body("students", hasSize(studentIds.size()))
            .extract().as(Group.class);
    Assert.assertEquals(newGroup.name, "HomeTask");
    Assert.assertEquals(newGroup.students.size(), 1);
    }

}

