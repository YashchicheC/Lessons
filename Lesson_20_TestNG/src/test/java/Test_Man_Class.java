import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test_Man_Class
{
    int ageTest = 30;
    Man newMan;

    @BeforeClass
    public void inst()    {
        newMan = new Man("Fedor", "Che", ageTest);
    }

    @Test()

    public void test_1_1_CreateExample()    {

        newMan = new Man("Fedor", "Void", 18);
        newMan.age = ageTest + 45;
        System.out.println(newMan.firstName + "_" + newMan.age);
    }

    @Test
    public void test_1_2_CreateEmptyExampleWithBaseName()    {

        newMan = new Man("", "", 0);
    }

    @Test
    public void test_1_3_GetLastNamePositive()    {

        newMan = new Man("", "", 0);
        System.out.println(newMan.getLastName());
        newMan = new Man("Model_1", "Model_2", 0);
        System.out.println(newMan.getLastName());
    }

    @Test
    public void test_1_4_IsRetiredPositive()    {
        assert newMan.isRetired(70);
    }

    @Test
    public void test_1_5_IsRetiredNegative()    {
        assert newMan.isRetired(20);
    }

    @Test
    public void test_1_6_RegisterPartnership()    {
        newMan = new Man("", "", 0);
        newMan.registerPartnership(new Woman("Shoto", "Gdeto", 45));
        System.out.println(newMan.partner.firstName + newMan.partner.age);
    }

    @Test
    public void test_1_7_DeegisterPartnership()    {
        newMan.deregisterPartnership(newMan.partner);
    }
}
