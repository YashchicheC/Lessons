public class Main
{
    public static void main(String[] args)
    {
        int i1 = 1;
        int i2 = 3;
        int i3 = 2;
        int i4 = 4;

        int result1 = i1 + i2;
        int result2 = i3 + i4;

        System.out.println("result1 > result2 = " + (result1 > result2));
        result1 += 1;
        result2 = result2 - 2;
        System.out.println("result1+1 = " + result1);
        System.out.println("result2-2 = " + result2);
        System.out.println("result1 > result2 second comparison = " + (result1 > result2));
        System.out.println("result1 or result2 are multiple of 2 = " + (result1%2 ==0 || result2%2 ==0));
        String result = ("".length() == 6) ? "First" : "Second";
        System.out.println("result" + result);
    }
}
