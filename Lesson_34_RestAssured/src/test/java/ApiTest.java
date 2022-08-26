import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

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

    @Test(priority = 3)
    public void addGroupPostRequest()
    {
        List<Student> arrayOfStudentsAsList = Arrays.asList //вытягиваем всех студентов, что созданы ранее в students в виде списка
        (
                RestAssured.get("/students")
                .then().statusCode(200)
                .extract().as(Student[].class)
        );

        List<Integer> studentIdList = arrayOfStudentsAsList.stream().map(student -> student.id).toList(); // забираем со списка студентов только ID

        Response response = RestAssured.given()//отдаем на создание список с названием "NewGroup" и список ID студентов
                .body(new StudentToGroup("NewGroup", studentIdList))
                .post("/groups");
        response.then().statusCode(200);

        //Assert.assertEquals(response.as(StudentToGroup.class).name, "NewGroup");
        Assert.assertEquals(response.as(StudentToGroup.class).students.size(), 3);


        studentIdList = arrayOfStudentsAsList.stream().map(student -> student.id).toList();
        System.out.println(studentIdList);

        //    StudentData [] arrayOfStudents = new StudentData[]{new StudentData("One", "Onest"),(new StudentData("Two", "Twost")),(new StudentData("Three", "Threest"))};

        /*RestAssured.given()
                .body(new StudentData ("One", "Onest"))
                .post("/group")
                .then().statusCode(200);

        RestAssured.given()
                .body(new StudentData("Two", "Twost"))
                .post("/group")
                .then().statusCode(200);

       /* RestAssured.given()
                .body(new StudentData("Three", "Threest"))
                .post("/group")
                .then().statusCode(200);*/
    }
}
