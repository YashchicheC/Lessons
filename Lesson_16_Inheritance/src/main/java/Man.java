public class Man extends Person
{
Person person = new Person("Black","Bullock", 61, false);


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
    protected boolean isRetired(int ageOfPerson)
    {
        if (ageOfPerson > 65)
        {
            return true;
        }
            return false;
    }

    @Override
    protected String registerPartnership(String newSurname) {
        return person.firstName;
    }

    @Override
    protected String deregisterPartnership(boolean areYouMarriedNow) {
        return person.firstName;
    }

}
