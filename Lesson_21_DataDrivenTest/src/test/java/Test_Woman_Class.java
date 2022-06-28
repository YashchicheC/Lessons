import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test_Woman_Class{
    int ageTest = 30;
    Woman woman;

    @BeforeClass
    public void inst()    {
        woman = new Woman("Marusya", "Moroz", ageTest);
    }

    @Test ()

    public void test_1_1_CreateExample()    {

        woman = new Woman("Marusya", "Moroz", 18);
        woman.age = ageTest + 20;
        System.out.println(woman.firstName + "_" + woman.age);
    }

    @Test
    public void test_1_2_CreateEmptyExampleWithBaseName()    {

        woman = new Woman("", "", 0);
        System.out.println(woman.firstName + "_" + woman.firstName + woman.age);
    }

    @Test
    public void test_1_3_GetLastNamePositive()    {

        woman = new Woman("", "", 0);
        woman.getLastName();

    }

    @Test
    public void test_1_4_IsRetiredPositive()    {
        assert woman.isRetired(65);
    }

    @Test
    public void test_1_5_IsRetiredNegative()    {

        assert woman.isRetired(-1);
    }

    @Test
    public void test_1_6_RegisterPartnership()    {
        woman = new Woman("", "", 0);
        woman.registerPartnership(new Man("Vasya", "Pupkin", 25));
        System.out.println(woman.partner.firstName + woman.partner.age);
    }

    @Test
    public void test_1_7_DeegisterPartnership()    {
        woman.deregisterPartnership(woman.partner);
    }

}
