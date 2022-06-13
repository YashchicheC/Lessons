import java.util.ArrayList;
import java.util.*;

public class Main
{
    static ArrayList<String> charlist = new ArrayList<>();

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

        for (int i = 0; i < mainList.size(); i++)
        {
            String s = mainList.get(i); //одно слово с пробелом
            s = s.replace(" ", "");//удаляем пробел в слове
            CountCharsAndPut(s); //скармливаем методу полученную строку
        }

        Set <Character> sett = new HashSet<>(); //для финальных букв

        for (int i = 0; i < charlist.size(); i++)
        {
            char[] finalArray = charlist.get(i).toCharArray();

            for (int j = 0; j < finalArray.length; j++)
            {
                sett.add(finalArray[j]);
            }
        }
        System.out.println(sett);
    }

    private static void CountCharsAndPut(String str)
    {
        for(int i = 0; i < str.length(); i++)
        {
            int countChar = 0;

            for (int j = 0; j < str.length(); j++)
            {
                if (str.charAt(i) == str.charAt(j)) //проверка буквы на наличие дубликати в слове
                {
                    countChar++;
                }
            }
            if (countChar % 2 != 0) //если буква не нашла свой дулбликат то выходим с цикла, выбрасывая из CountCharsAndPut
            {
                return;
            }
        }
        if (charlist.size() < 2)
        {
            charlist.add(str); //список слово по критерию "каждая буква повторяется дважды"
        }
    }
}



