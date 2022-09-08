package api;

public class UserTest2
{
    private String session_token;
    private String username;
    private String valid_to;

    public UserTest2(String session_token, String username, String valid_to) {
        this.session_token = session_token;
        this.username = username;
        this.valid_to = valid_to;
    }
    public UserTest2(){}

    public String getSession_token() {
        return session_token;
    }

    public String getUsername() {
        return username;
    }

    public String getValid_to() {
        return valid_to;
    }
}
