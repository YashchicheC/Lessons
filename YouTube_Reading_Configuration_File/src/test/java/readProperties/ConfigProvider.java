package readProperties;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider
{
    Config config = readConfig();
    //для Config надо импорт библиотеки Config (com.typesafe.config)
    static Config readConfig()
    {
        return ConfigFactory.systemProperties().hasPath("testProfile")
        ? ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile"))
        : ConfigFactory.load("app.conf");
    }
    String URL = readConfig().getString("url");
    Integer age = readConfig().getInt("age");
    /**точка показывает вложение. То бишь в UserParams, есть вложение demo, в котором есть вложение isAdmin */

    String adminLogin = readConfig().getString("usersParams.admin.login");
    String demoPassword = readConfig().getString("usersParams.demo.password");
    Boolean is_demo_admin = readConfig().getBoolean("usersParams.demo.isAdmin");
}
