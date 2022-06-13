public class Man extends Person
{
    public Man(String firstName, String lastName, int age){
        super(firstName, lastName, age);
    }

    @Override
    protected boolean isRetired(int ageOfPerson)
    {
        if (ageOfPerson > 65)
        {
            return true;
        }
            return false;
    }

    @Override
    protected String deregisterPartnership(Person other) {
        super.deregisterPartnership(other);
        return lastName;
    }

}
