package api;

import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Test;

import java.time.Clock;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class ReqresTest
{
    /** из видео https://www.youtube.com/watch?v=gxzXOMxIt4w&t */
    private final static String URL = "https://reqres.in/";

    @Test
    public void checkAvatarAndIdTest()
    {
      /**  ЗАДАНИЕ (через GET)
                1.Используя сервис https://reqres.in/ получить список пользователей с api/users?page=2"
                2. Убедится что имена файлов-аватаров совпадают с id пользователя
                3. Убедится, что email пользователей имеет окончание reqres.in*/

        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpec200());
        List<UserData> users = given()
                .when()
                .get ("api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class); //---> "data" - это название списка что возвращается

       users.forEach(x->Assert.assertTrue(x.getAvatar().contains(x.getId().toString())));
       Assert.assertTrue(users.stream().allMatch(x->x.getEmail().endsWith("@reqres.in")));

       List<String> avatars = users.stream().map(UserData::getAvatar).collect(Collectors.toList());
       List<String> ids = users.stream().map(x->x.getId().toString()).collect(Collectors.toList());

       for (int i = 0; i< avatars.size(); i++)
        {
            Assert.assertTrue(avatars.get(i).contains(ids.get(i)));
        }
    }
    @Test
    public void successRegTest()
    {
         /**  ЗАДАНИЕ (через POST)
                1.Используя сервис https://reqres.in/ протестировать решистрацию пользователя в системе
                2. Необходимо создание 2 тестов:
                - успешная регистрация
                - регистрация с ошибкой из-за отсутствия пароля
                3. Проверить коды ошибок*/

        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpec200());
        Integer id = 4; //это данные с сайта, которые указываются в response запроса при REGISTER - SUCCESSFUL
        String token = "QpwL5tke4Pnpja7X4"; //это данные с сайта, которые указываются в response запроса при REGISTER - SUCCESSFUL
        Register user = new Register("eve.holt@reqres.in","pistol");
        SuccessRegister successReg = given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().as(SuccessRegister.class);

        Assert.assertNotNull(successReg.getId());
        Assert.assertNotNull(successReg.getToken());

        Assert.assertEquals(id, successReg.getId());
        Assert.assertEquals(token, successReg.getToken());
    }
    @Test
    public void negativeRegTest()
    {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecError400());
        Register userForNegativeTest = new Register("sydney@fife", "");

        NegativeRegistration negReg = given()
                .body(userForNegativeTest)
                .post("api/register")
                .then().log().all()
                .extract().as(NegativeRegistration.class);
        Assert.assertNotNull(negReg.getError());
        Assert.assertEquals("Missing password", negReg.getError());

    }

    @Test
    public void dataByYears()
    {
         /**  ЗАДАНИЕ (через GET)
                1.Используя сервис https://reqres.in/ убедится, что операция LIST <RESOURCE> возвращает данные
                2. Данные долэны быть отсортированы по годам
                3. Request для данного запроса по линке /api/unknown*/
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpec200());
        List<ColorsData> colors = given()
                .when()
                .get ("api/unknown")
                .then().log().all()
                .extract().body().jsonPath().getList("data", ColorsData.class);

        List<Integer> years = colors.stream().map(ColorsData::getYear).collect(Collectors.toList());
        List<Integer> sortedYears = years.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());

        Assert.assertEquals(sortedYears, years);

    }

    @Test
    public void deleteUserTest()
    {
         /**  ЗАДАНИЕ (через DELETE)
                1.Используя сервис https://reqres.in/ попробовать удалить второго пользователя и сравнить статус-код*/
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseUniqueCode(204));
        given()
                .when()
                .delete("api/users/2")
                .then().log().all();
    }

    @Test
    public void updateLocalTime()
    {
         /**  ЗАДАНИЕ
                1.Используя сервис https://reqres.in/ обновить информацию о пользователе и сравнить дату обновления с текущей датой на компьютере*/
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseUniqueCode(204));
        given()
                .when()
                .delete("api/users/2")
                .then().log().all();
    }

    @Test
    public void timeTest()
    {


        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpec200());
        UserTimeTesting user= new UserTimeTesting("morpheus", "zion resident");
        UserTimeResponse response = given()
                .body(user)
                .when()
                .put("api/users/2")
                .then().log().all()
                .extract().as(UserTimeResponse.class);
        String regex = "(.{12})$";//------> знак $ означает, что символы будут удаляться с конца. То бишь вместо 2022-09-01T11:47:15.581089600Z будет 2022-09-01T11:47:5
        String regexForResponce = "(.{6})$";
        String currentTime = Clock.systemUTC().instant().toString().replaceAll(regex, "");
        String responseTime = response.getUpdatedAt().replaceAll(regexForResponce, "");

        System.out.println(currentTime + "--------------------");
        System.out.println(responseTime + "+++++++++++++++++++++++++++");

        Assert.assertEquals(currentTime,responseTime);

    }
}

