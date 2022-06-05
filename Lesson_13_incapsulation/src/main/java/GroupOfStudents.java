import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class GroupOfStudents
{
   private int rand;
   private ArrayList<StudentData> listOfStudent = new ArrayList<>();

   public void setRand(int random){ this.rand = random;}
    public int getRand() {return rand;}

    public void setListOfStudent(ArrayList<StudentData> listOfStudent) {
        this.listOfStudent = listOfStudent;
    }

    public ArrayList<StudentData> getListOfStudent() {
        return listOfStudent;
    }

    public void fillingGroup()
    {
        listOfStudent.clear();

       ArrayList <Integer> idLIst = new ArrayList<>(Arrays.asList(1,2,3,4,5));
       ArrayList <String> nameList =  new ArrayList<>(Arrays.asList("Boris","Andrzei", "Egils", "Gitanas", "Alar"));
       ArrayList <String> surnameList = new ArrayList<>(Arrays.asList("Johnson", "Duda", "Levits", "Nauseda","Karis"));

        for (int i = 0; i < 5; i++) //произвольное, базовое количество студентов (к примеру 5)
        {
            StudentData  studData = new StudentData();
            studData.setStudent_ID(idLIst.get(i));
            studData.name = nameList.get(i);
            studData.surname = surnameList.get(i);
            listOfStudent.add(studData);
        }
        rand  = ThreadLocalRandom.current().nextInt(0,  listOfStudent.size());
    }


    public void randomHeadman (int random)
    {
        listOfStudent.get(random).headman = true;
    }

    public void changeHeadman (int index)
    {
        for (int i = 0; i < listOfStudent.size(); i++)
        {
            if (index == listOfStudent.get(i).getStudent_ID())
            {
                listOfStudent.get(i).headman = true;
            }
            else listOfStudent.get(i).headman = false;
        }
    }
    public void addStudent (int studentID, String studentName, String studentSurname)
    {
        StudentData studData = new StudentData();
        studData.setStudent_ID(studentID);
        studData.name = studentName;
        studData.surname = studentSurname;
        listOfStudent.add(studData);
    }
    public void deleteStudent (int numberOfTheList)
    {
        listOfStudent.remove(numberOfTheList);
    }
    public void renameStudent (int studentIndex, String studentNewName, String studentNewSurname)
    {
        for (int i = 0; i < listOfStudent.size(); i++)
        {
            StudentData studData = listOfStudent.get(i);
            if (studData.getStudent_ID() == studentIndex)
            {
                listOfStudent.get(i).name = studentNewName;
                listOfStudent.get(i).surname = studentNewSurname;
            }
        }
    }
    public void newHometask (String newTask)
    {
        for (int i = 0; i < listOfStudent.size(); i++)
        {
            listOfStudent.get(i).item.add(newTask);
        }
    }
    public void homeworkHasDone (int studentIndex, String whatYouDid, boolean yeap)
    {

        for (int i = 0; i < listOfStudent.size(); i++)
        {

            if (listOfStudent.get(i).getStudent_ID() == studentIndex && listOfStudent.get(i).item.contains(whatYouDid))
            {
                listOfStudent.get(i).homework_done = yeap;
            }
        }

    }
    public void lookAllStudents ()
    {
        for (int i = 0; i < listOfStudent.size(); i++)
        {
            System.out.println("ID: " + listOfStudent.get(i).getStudent_ID() + " Name: " + listOfStudent.get(i).name + " Surname: " + listOfStudent.get(i).surname + " Headman: " + listOfStudent.get(i).headman + " Homework has Done: " + listOfStudent.get(i).homework_done);
        }
    }
}

