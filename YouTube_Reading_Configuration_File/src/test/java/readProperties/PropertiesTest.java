package readProperties;

import org.junit.Test;

import java.io.IOException;

public class PropertiesTest extends BaseTest
{
    @Test
    public void readProperties() throws IOException
    {
        /**
         * Для того, чтоб на самой папке resources появились значки и она распознавалась как ресурсная, надо:
         * Нажать одновременно Ctrl+Shift+Alt+S и открываем Project Structure
         * Выбрать вкладку Modules (слева). Потом выбрать вкладку Sources (справа)
         * В дереве папок находим нужную (resources) и клацаем Mouse 2 по ней, и из выпавшего списка выбираем Test Resources
         * Так же это описано на https://russianblogs.com/article/52401729075/ в "2, метод"
         * Если этого не сделать, то при наведении на с зажатым Ctrl на app.properties и клике, не будет открывать файл и будет ошибка
         */
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("app.properties"));
        String urlFromProperty = System.getProperty("url");
        System.out.println(urlFromProperty);

    }
    @Test
    public void readFromConf()
    {
        /**
         * Если нам нужен один файл properties с простыми данными, то нам нужно создать для теста только BaseTest, PropertiesTest и app.properties в папке resources
         * Если логика рассчитана на то, чтобы была проверка более сложная. То бишь несколько пользователей с разными именами и данными, то дополнительно
         * создаем файл app.conf (это уже файл конфигурации), далее устанавливаем в pom.xml библиотеку typesafe-Config https://mvnrepository.com/artifact/com.typesafe/config
         * в файл app.conf можно задавать string, int, массив и список данных - как в примере
         * Далее создаем интерфейс ConfigProvider
         */
        String urlFromConfig = ConfigProvider.URL;
        System.out.println(urlFromConfig);
        Boolean isDemoAdmin = ConfigProvider.is_demo_admin;
        System.out.println(isDemoAdmin);

        if(ConfigProvider.readConfig().getBoolean("usersParams.admin.isAdmin"))
        {
            System.out.println("Админ и есть админ");
        }
        else
        {
            System.out.println("Xnj-то не то");
        }
    }
}
