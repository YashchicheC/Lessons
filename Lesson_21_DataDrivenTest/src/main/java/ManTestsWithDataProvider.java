import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ManTestsWithDataProvider
{
    @DataProvider (name = "Person test data")
    public Object[][] getTestData() {
        return new Object[][]
                {
                {6, "Nothing problem"},
                {25, "Death starts to speak with me"}
                };
    }
    @Test (dataProvider = "Person test data")
    public void LessonExample2( int personAge, String health)
    {
        Person man = new Man("Fedor", "Void", personAge);
        assert man.getHealth().equals(health);
        System.out.println(man.getHealth());
        System.out.println(personAge);
    }
    ////////////////////////////////////////////////////// - homework
    @DataProvider (name = "createNewMan")
    public Object[][] man()
    {
        return new Object[][]{{new Man("Fedor", "Void", 71)}};
    }

    int ageTest = 30;
    @Test(dataProvider = "createNewMan")

    public void test_1_1_CreateAndChangingAge(Man newMan)    {

        if (newMan!=null) {
            newMan.age = ageTest + 45;
        }
        assert newMan.age == ageTest + 45;

    }

    @DataProvider (name = "createNewEmptyMan")
    public Object[][] newMan(){
        return new Object[][]{{new Man("", "", 0)}};
    }

    @Test(dataProvider = "createNewEmptyMan")
    public void test_1_2_CreateEmptyExampleWithBaseName(Man newMan)    {

        assert "BaseFirstName".equals(newMan.firstName);
        assert "BaseLastName".equals(newMan.getLastName());
        assert newMan.age == 18;
    }

    @DataProvider (name = "createTwoNewMan")
    public Object[][] twoMen()
    {
        return new Object[][]
                {
                        {new Man("", "", 0), new Man("Model_1", "Model_2", 50)}
                };
    }
    @Test(dataProvider = "createTwoNewMan")
    public void test_1_3_GetLastNamePositive(Man[] mans)    {

        assert mans[0].getLastName() != null;
        assert !mans[0].getLastName().equals("");
        System.out.println(mans.length);
        mans[1] = new Man("Model_1", "Model_2", 0);
        assert "Model_2".equals(mans[1].getLastName());
    }

    @Test(dataProvider = "createNewMan")
    public void test_1_4_IsRetiredPositive(Man newMan)    {
        assert newMan.isRetired(newMan.age);
    }

    @Test (dataProvider = "createNewEmptyMan")
    public void test_1_7_RegisterPartnership (Man newMan)    {
        assert newMan.registerPartnership(new Woman("Shoto", "Gdeto", 45)) != null;
        assert "BaseLastName".equals(newMan.getLastName());
        assert "Gdeto".equals(newMan.partner.getLastName());
    }

    @Test (dataProvider = "createNewEmptyMan")
    public void test_1_8_DeegisterPartnership(Man newMan)    {
        if (newMan.partner != null) {
            newMan.deregisterPartnership(newMan.partner);
        }
        assert newMan.partner == null;
    }
}
