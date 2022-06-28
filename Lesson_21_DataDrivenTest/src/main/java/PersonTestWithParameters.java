import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PersonTestWithParameters
{
    @Test
    @Parameters({"age", "expectedEd"})
    public void LessonExample( int personAge, String health){
        Person person = new Person("Unagi", "Void", personAge) {
            @Override
            public String getHealth() {
                return super.getHealth();
            }
        };
        assert person.getHealth().equals(health);
        System.out.println(person.getHealth());
        System.out.println(personAge);

    }
}
