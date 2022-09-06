package api;

public class UserTimeTesting
{
    private String name;
    private String job;

    public UserTimeTesting(String name, String job)
    {
        this.name = name;
        this.job = job;
    }
    UserTimeTesting(){}

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }
}
