public class Main
{
    public static void main(String[] args)
    {
       Woman woman = new Woman();
       Man man = new Man();

        System.out.println("Man age " + man.age);
        System.out.println("is this man(person) retired " + man.isRetired(man.age));
        System.out.println("A man, which surname was after partnership? " + man.registerPartnership("Wachowsky"));
        System.out.println("A man, tired of being married?. But surname still " + man.deregisterPartnership(true));
        System.out.println("--------------------------");
        System.out.println("Woman age " + woman.age);
        System.out.println("is this woman(person) retired " + woman.isRetired(woman.age));
        System.out.println("A woman, which surname was after partnership? " + woman.registerPartnership("Wachowsky"));
        System.out.println("A woman, tired of being married? And surname change " + woman.deregisterPartnership(false));
    }
}
