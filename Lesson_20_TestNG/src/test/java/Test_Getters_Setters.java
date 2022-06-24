import org.testng.annotations.Test;

public class Test_Getters_Setters
{
    @Test
    public void test_1_1_ManSetAge()    {

        Man man = new Man("I", "U", 30);
        man.setAge(20);
        System.out.println(man.getAge());
    }
    @Test
    public void test_1_1_ManGetLastName()    {

        Man man = new Man("I", "U", 30);
        man.getLastName();
        System.out.println(man.getLastName());
    }
    @Test
    public void test_1_1_WomanSetAge()    {

        Woman woman = new Woman("IIIII", "UUUUU", 70);
        woman.setAge(10);
        System.out.println( woman.getAge());
    }
    @Test
    public void test_1_1_WomanGetLastName()    {

        Woman woman = new Woman("IIIII", "UUUUU", 70);
        woman.getLastName();
        System.out.println(woman.getLastName());
    }
}
