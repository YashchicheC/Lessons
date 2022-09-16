package api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class ReqresNoPojoTest
{
    /** из видео https://www.youtube.com/watch?v=z9Tvxh6uQzI&t */
    private final static String URL = "https://reqres.in";

    @Test
    public void checkAvatarsNoPojoTest()
    {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpec200());
        Response response = given()
                .when()
                .get("/api/users?page=2")
                .then().log().all()
                .body("page", equalTo(2))             //метод из библиотеки Hamcrest
                .body("data.id", notNullValue())
                //data.id, здесь data - названиен списка, "." - это доступ по внутреннее содержимое списка, id - параметр списка
                //equalTo(7) при этом мы сделать не можем, так как в ответе массив id, а не один обьект
                .body("data.email", notNullValue())
                .body("data.first_name", notNullValue())
                .body("data.last_name", notNullValue())
                .body("data.avatar", notNullValue())
                .extract().response();

        JsonPath jsonPath = response.jsonPath(); //превращаем ранее созданный response (уже с сервера) в json
        List<String> emails = jsonPath.get("data.email"); //у нас получается список из всех имейлов, что пришли в ответе
        List<Integer> ids =  jsonPath.get("data.id"); //тоже самое, только список id
        List<String> avatars =  jsonPath.get("data.avatar");

        for (int i = 0; i < avatars.size(); i++)
        {
            Assert.assertTrue(avatars.get(i).contains(ids.get(i).toString()));
        }
        Assert.assertTrue(emails.stream().allMatch(x->x.endsWith("@reqres.in")));
    }
    @Test
    public void postRequestSuccessUserRegNoPojo()
    {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpec200());
        Map<String, String> user = new HashMap<>();
        user.put("email", "eve.holt@reqres.in"); //смотрим метод successRegTest в ReqresTest
        user.put("password", "pistol"); //register и password - это названия полей для отправляемого json, а eve.holt@reqres.in и pistol - их значения
        Response response = given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .body("id", equalTo(4))
                .body("token", equalTo("QpwL5tke4Pnpja7X4"))
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        int id = jsonPath.get("id");
        String token = jsonPath.get("token");
        Assert.assertEquals(4, id);
        Assert.assertEquals("QpwL5tke4Pnpja7X4", token);
    }
    @Test
    public void unsuccessUserRegNOPojo()
    {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecError400());
        Map<String, String> user = new HashMap<>();
        user.put("email","sydney@fife"); //отправляемые данные
        Response response = given()
                .body(user)
                .when()
                .post("/api/register")
                .then().log().all()
                .body("error", equalTo("Missing password")) //ответ, что должен придти
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        String error = jsonPath.get("error");
        Assert.assertEquals("Missing password", error);
    }

}
