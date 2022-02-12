public class SecondClass
{
    int i = 11111;
    String str = String.format("---<%s>---", i);

    public  String methodPrint(String[] args)
    {
        System.out.printf(args);
        return str;
    }
}
