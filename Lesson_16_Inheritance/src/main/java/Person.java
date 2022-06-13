public abstract class Person
{
   protected String firstName = "Base";
   protected String lastName = "New Base";
   protected int age = 18;
   protected Person partner;

  public Person (String firstName, String lastName, int age)
   {
      this.firstName = firstName;
      this.lastName = lastName;
      this.age = age;

   }
   public Person(){}

   public void setAge(int age) {
      this.age = age;
   }

   public int getAge() {
      return age;
   }

   public String getLastName() {return lastName;}

   protected boolean isRetired (int ageOfPerson)
   {
      if (ageOfPerson > 60)
      {
         return true;
      }
       return false;
   }
    protected String registerPartnership (Person person)
    {
        this.partner = person;
        return lastName;
    }
    protected String deregisterPartnership (Person other)
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
