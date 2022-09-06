package api;

public class UserTimeResponse extends UserTimeTesting
{
    private String updatedAt;
    public UserTimeResponse (String name, String job, String updatedAt)
    {
        super(name, job);
        this.updatedAt = updatedAt;
    }
    UserTimeResponse(){}

    public String getUpdatedAt() {
        return updatedAt;
    }
}
