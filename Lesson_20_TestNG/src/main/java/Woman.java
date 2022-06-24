import java.io.*;
public class Woman extends Person
{
    public String marriagelastName;
    public Woman (String firstName, String lastName, int age)
    {
        super(firstName, lastName, age);
    }

    @Override
    public String getLastName() {
        return partner != null ? marriagelastName : lastName;
    }

    @Override
    public String registerPartnership(Person other) {
        partner = other;
        marriagelastName = other.lastName;
        return marriagelastName;
    }
}