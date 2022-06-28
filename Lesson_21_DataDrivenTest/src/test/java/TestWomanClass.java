import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestWomanClass {
    int ageTest = 30;
    Woman newWoman;
    @Test ()

    public void test_1_1_CreateExample()    {

        newWoman = new Woman("Marusya", "Moroz", 18);
        if (newWoman != null) {
            newWoman.age = ageTest + 20;
            System.out.println(newWoman.firstName + "_" + newWoman.age);
        }
        assert newWoman.age == ageTest + 20;
    }

    @Test
    public void test_1_2_CreateEmptyExampleWithBaseName()    {

        newWoman = new Woman("", "", 0);
        assert newWoman.getLastName().equals("BaseLastName");
        assert newWoman.age == 18;
        assert newWoman.firstName.equals("BaseFirstName");

    }

    @Test
    public void test_1_3_GetLastNamePositive()    {

        newWoman = new Woman("", "", 0);
        assert newWoman.getLastName() != null;
        assert !newWoman.getLastName().equals("");

        newWoman = new Woman("Model_1", "Model_2", 0);
        assert newWoman.getLastName().equals("Model_2");
    }

    @Test
    public void test_1_4_IsRetired()    {
        assert newWoman.isRetired(65);
    }


    @Test
    public void test_1_6_RegisterPartnership()    {
        newWoman = new Woman("", "", 0);
        newWoman.registerPartnership(new Man("Vasya", "Pupkin", 25));
        assert newWoman.getLastName().equals(newWoman.partner.lastName);
        assert "Pupkin".equals(newWoman.getLastName());
    }

    @Test
    public void test_1_7_DeregisterPartnership()    {
        newWoman = new Woman("Marusya", "Moroz", 18);
        newWoman.deregisterPartnership(newWoman.partner);
        assert newWoman.partner == null;
    }
}