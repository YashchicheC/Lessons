public class Person
{
   protected String firstName = "Base";
   protected String lastName = "New Base";
   private int age = 18;
   protected boolean partner;

  public Person (String firstName, String lastName, int age, boolean partner)
   {
      this.firstName = firstName;
      this.lastName = lastName;
      this.age = age;
      this.partner = partner;
   }
   public Person(){}

   public void setAge(int age) {
      this.age = age;
   }

   public int getAge() {
      return age;
   }

   protected boolean isRetired (int ageOfPerson)
   {
      if (ageOfPerson > 60)
      {
         return true;
      }
       return false;
   }
    protected String registerPartnership (String newSurname)
    {
        lastName = newSurname;
        return lastName;
    }
    protected String deregisterPartnership (boolean areYouMarriedNow)
    {
        if (areYouMarriedNow == false)
        {
            return firstName;
        }
        return lastName;

    }
}
