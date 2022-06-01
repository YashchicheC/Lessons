import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class GroupOfStudents
{
   static int rand;
   public static ArrayList<StudentData> listOfStudent = new ArrayList<>();

    public static void main(String[] args)
    {
        FillingGroup();
        RandomHeadman(rand);
        AddStudent(006, "Vasya", "Pupkin");
        DeleteStudent(001);
        RenameStudent(006, "Sysan", "Pupkini");
        ChangeHeadman(003);
        NewHometask("do the new task");
        HomeworkHasDone(3, true);
        LookAllStudents();
    }
    private static void FillingGroup()
    {
        listOfStudent.clear();

        ArrayList <Integer> idLIst = new ArrayList<>(Arrays.asList(001,002,003,004,005));
        ArrayList <String> nameList =  new ArrayList<>(Arrays.asList("Boris","Andrzei", "Egils", "Gitanas", "Alar"));
        ArrayList <String> surnameList = new ArrayList<>(Arrays.asList("Johnson", "Duda", "Levits", "Nauseda","Karis"));

        for (int i = 0; i < 5; i++) //произвольное, базовое количество студентов (к примеру 5)
        {
            StudentData  studData = new StudentData();
            studData.student_ID = idLIst.get(i);
            studData.name = nameList.get(i);
            studData.surname = surnameList.get(i);
            listOfStudent.add(studData);
        }
        rand  = ThreadLocalRandom.current().nextInt(0,  listOfStudent.size());
    }

    private static void RandomHeadman (int random)
    {
        listOfStudent.get(random).headman = true;
    }

    private static void ChangeHeadman (int index)
    {
        for (int i = 0; i < listOfStudent.size(); i++)
        {
            if (index == listOfStudent.get(i).student_ID)
            {
                listOfStudent.get(i).headman = true;
            }
            else listOfStudent.get(i).headman = false;
        }
    }
    private static void AddStudent (int studentID, String studentName, String studentSurname)
    {
        StudentData studData = new StudentData();
        studData.student_ID = studentID;
        studData.name = studentName;
        studData.surname = studentSurname;
        listOfStudent.add(studData);
    }
    private static void DeleteStudent (int studentID)
    {
        listOfStudent.remove(studentID);
    }
    private static void RenameStudent (int studentIndex, String studentNewName, String studentNewSurname)
    {
        for (int i = 0; i < listOfStudent.size(); i++)
        {
            StudentData studData = listOfStudent.get(i);
            if (studData.student_ID == studentIndex)
            {
                listOfStudent.get(i).name = studentNewName;
                listOfStudent.get(i).surname = studentNewSurname;
            }
        }
    }
    private static void NewHometask (String newTask)
    {
        for (int i = 0; i < listOfStudent.size(); i++)
        {
            listOfStudent.get(i).item = newTask;
        }
    }
    private static void HomeworkHasDone (int studentIndex, boolean yeap)
    {

        for (int i = 0; i < listOfStudent.size(); i++)
        {
            if (listOfStudent.get(i).student_ID == studentIndex)
            {
                listOfStudent.get(i).homework_done = yeap;
            }
        }
    }
    private static void LookAllStudents ()
    {
        for (int i = 0; i < listOfStudent.size(); i++)
        {
            System.out.println("ID: " + listOfStudent.get(i).student_ID + " Name: " + listOfStudent.get(i).name + " Surname: " + listOfStudent.get(i).surname + " Headman: " + listOfStudent.get(i).headman + " Homework has Done: " + listOfStudent.get(i).homework_done);
        }
    }
}

