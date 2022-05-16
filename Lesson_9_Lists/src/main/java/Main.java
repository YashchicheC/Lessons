import java.util.ArrayList;

public class Main
{

    public static void main(String[] args)
    {
        ArrayList<String> mainList = new ArrayList<>();
        mainList.add("kit kit");
        mainList.add("foo");
        mainList.add("bar");
        mainList.add("maki maki");
        mainList.add("baz");
        mainList.add("quiz");
        mainList.add("song");
        mainList.add("chacha");

        int counter = 0;

        ArrayList<Character> charList = new ArrayList<>();

        for (int i = 0; i < mainList.toString().length();i++)
        {
            charList.add(mainList.toString().charAt(i));
        }
        for (int i = 0; i < charList.size();i++)
        {
            for (int y = 0; y < charList.size(); y++)
            {
                if (charList.get(i) == charList.get(y))
                {
                    charList.remove(y);
                    if (charList.contains("*"))
                    {
                        charList.remove(y);
                        charList.toString().replaceAll(" ", "*");
                    }
                }
            }

        }
        charList.toString().trim();
        System.out.println(charList);

    }
}
