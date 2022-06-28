import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WomanTestsWithDataProvider {
    int ageTest = 30;

    @DataProvider (name = "createNewWoman")
    public Object[][] Woman()
    {
        return new Object[][]{{new Woman("Fedor", "Void", 11)}};
    }

    @Test(dataProvider = "createNewWoman")

    public void test_1_1_CreateExample(Woman newWoman)    {

        if (newWoman != null) {
            newWoman.age = ageTest + 20;
            System.out.println(newWoman.firstName + "_" + newWoman.age);
        }
        assert newWoman.age == ageTest + 20;
    }


    @DataProvider (name = "createNewEmptyWoman")
    public Object[][] newWoman(){
        return new Object[][]{{new Woman("", "", 0)}};
    }
    @Test (dataProvider = "createNewEmptyWoman")
    public void test_1_2_CreateEmptyExampleWithBaseName(Woman newWoman)    {

        assert newWoman.getLastName().equals("BaseLastName");
        assert newWoman.age == 18;
        assert newWoman.firstName.equals("BaseFirstName");
    }
////////////////////////////////////////////////////////
@DataProvider (name = "createWoman")
public Object[][] newWoman_2(){
    return new Object[][]{{new Woman("UUU", "TTT", 20)}};
}

    @Test (dataProvider = "createNewEmptyWoman")
    public void test_1_3_GetLastNamePositive(Woman newWoman){
        assert newWoman.getLastName() != null;
        assert !newWoman.getLastName().equals("");
    }
    @Test (dataProvider = "createWoman")
    public void test_1_3_1_GetLastNamePositive(Woman newWoman){
        assert "TTT".equals(newWoman.getLastName());
    }

    @DataProvider (name = "createWomanOld")
    public Object[][] newWomanOld(){
        return new Object[][]{{new Woman("UUU", "TTT", 61)}};
    }
    @Test(dataProvider = "createWomanOld")
    public void test_1_4_IsRetired(Woman newWoman){
        assert newWoman.isRetired(newWoman.age);
    }
    @DataProvider (name = "createTwoPersonForPartnership")
    public Object[][] twoPersonForPartnership()
    {
        return new Object[][]
                {
                        {new Woman("Julia", "Julls", 20), new Man("Ihor", "I", 50)}
                };
    }
    @Test (dataProvider = "createTwoPersonForPartnership")
    public void test_1_6_RegisterPartnership(Person[] partners)    {

        partners[0].registerPartnership(partners[1]);
        assert partners[0].getLastName().equals(partners[1].getLastName());
        assert "I".equals(partners[0].getLastName());
    }

    @Test  (dataProvider = "createWoman")
    public void test_1_7_DeregisterPartnership(Woman newWoman)    {
        if (newWoman.partner != null) {
            newWoman.deregisterPartnership(newWoman.partner);
        }
        assert newWoman.partner == null;
    }
}
