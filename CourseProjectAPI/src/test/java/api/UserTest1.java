package api;

public class UserTest1
{
    private String username;
    private String password;

    public  UserTest1(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public  UserTest1(){}

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
