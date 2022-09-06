package api;

public class NegativeRegistration
{
    private String error;

    public NegativeRegistration(String error)
    {
        this.error = error;
    }
    public NegativeRegistration(){}

    public String getError() {
        return error;
    }
}
