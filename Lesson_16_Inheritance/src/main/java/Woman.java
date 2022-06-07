public class Woman extends Person
{
    Person person = new Person("White","Winehouse", 70, true);

    int age = person.getAge();

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    protected String registerPartnership(String newSurname) {
        person.lastName = newSurname;
        return person.lastName;
    }

    @Override
    protected String deregisterPartnership(boolean areYouMarriedNow)
    {
        if (areYouMarriedNow == true)
        {
            return person.lastName;
        }
        return person.firstName;
    }


}
