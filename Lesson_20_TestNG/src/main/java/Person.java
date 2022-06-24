import java.io.*;
public abstract class Person
{
    protected String firstName = "BaseFirstName";
    protected String lastName = "BaseLastName";
    protected int age = 18;
    protected Person partner;

    public Person (String firstName, String lastName, int age)
    {
        if (!firstName.equals("")) {this.firstName = firstName;}
        if (!lastName.equals("")) {this.lastName = lastName;}
        if (age > 0) {this.age = age; }
    }
    public Person(){}

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getLastName()
    {
        if (lastName!= null)
        {
            return lastName;
        }
      return "Last name is empty";

    }

    public boolean isRetired (int ageOfPerson)
    {
        if (ageOfPerson > 60)
        {
            return true;
        }
        return false;
    }
    public String registerPartnership (Person person)
    {
        this.partner = person;
        return lastName;
    }
    public String deregisterPartnership (Person other)
    {
        if (partner != null && other.partner != null && partner == other.partner)//We are married
        {
            partner = null;
            other.partner = null;

            return lastName;
        }
        return lastName;

    }
}