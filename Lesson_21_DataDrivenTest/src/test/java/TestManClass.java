import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestManClass
{
    int ageTest = 30;
    Man newMan;

    @BeforeClass
    public void inst()    {
        newMan = new Man("Fedor", "Che", ageTest);
    }

    @Test()

    public void test_1_1_CreateAndChangingAge()    {

        newMan = new Man("Fedor", "Void", 18);
        if (newMan!=null) {
            newMan.age = ageTest + 45;
            System.out.println(newMan.firstName + "_" + newMan.age);
        }
        assert newMan.age == ageTest + 45;

    }

    @Test
    public void test_1_2_CreateEmptyExampleWithBaseName()    {

        newMan = new Man("", "", 0);

        assert "BaseFirstName".equals(newMan.firstName);
        assert "BaseLastName".equals(newMan.getLastName());
        assert newMan.age == 18;

    }

    @Test
    public void test_1_3_GetLastNamePositive()    {

        newMan = new Man("", "", 0);
        assert newMan.getLastName() != null;
        assert !newMan.getLastName().equals("");

        newMan = new Man("Model_1", "Model_2", 0);
        assert "Model_2".equals(newMan.getLastName());

    }

    @Test
    public void test_1_4_IsRetiredPositive()    {
        assert newMan.isRetired(70);
    }


    @Test
    public void test_1_7_RegisterPartnership()    {
        newMan = new Man("", "", 0);
        assert newMan.registerPartnership(new Woman("Shoto", "Gdeto", 45)) != null;
        assert "BaseLastName".equals(newMan.getLastName());
    }

    @Test
    public void test_1_8_DeegisterPartnership()    {
        newMan = new Man("Fedor", "Void", 18);
        if (newMan.partner != null) {
            newMan.deregisterPartnership(newMan.partner);
        }
        assert newMan.partner == null;
    }
}
